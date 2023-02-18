/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 29-Dec-2022 9:50:47 AM
*/

package com.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;
import com.app.excetions.ResourceNotFoundException;
import com.app.payloads.PostDTO;
import com.app.payloads.PostResponce;
import com.app.repository.CategoryRepo;
import com.app.repository.PostRepo;
import com.app.repository.UserRepo;
import com.app.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	public PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catergory", "CategoryId", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImagename("default.png");
		post.setDate(new Date());
		post.setCategory(category);
		post.setUser(user);

		Post newSave = this.postRepo.save(post);

		return this.modelMapper.map(newSave, PostDTO.class);
	}

	@Override
	public PostDTO updatePost(PostDTO postDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostID", postId));

		Category category = this.categoryRepo.findById(postDto.getCategory().getCategoryId()).get();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImagename(postDto.getImageName());
		post.setCategory(category);
		
		Post save = this.postRepo.save(post);
		return this.modelMapper.map(save, PostDTO.class);
	}

	@Override
	public void deletePost(Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostID", postId));
		this.postRepo.delete(post);
	}

	@Override
    public PostResponce getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePost = this.postRepo.findAll(p);

        List<Post> allPosts = pagePost.getContent();

        List<PostDTO> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());

        PostResponce postResponse = new PostResponce();

        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());

        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

	@Override
	public PostDTO getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
		return this.modelMapper.map(post, PostDTO.class);
	}

	@Override
	public List<PostDTO> getPostsByCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CatergoryId", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		List<PostDTO> postDto = posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDTO> getPostsByUser(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserID", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDTO> postDto = posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDTO> searchPosts(String keyword) {
		List<Post> posts  = this.postRepo.seachByTitle("%"+keyword+"%");
		List<PostDTO> postDto  = posts.stream().map((post)->this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		return postDto;
	}

}
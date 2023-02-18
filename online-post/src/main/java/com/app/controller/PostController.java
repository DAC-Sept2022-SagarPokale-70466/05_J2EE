/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 29-Dec-2022 10:09:00 AM
*/

package com.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.config.AppConstants;
import com.app.payloads.ApiResponce;
import com.app.payloads.PostDTO;
import com.app.payloads.PostResponce;
import com.app.service.FileService;
import com.app.service.PostService;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

//	private PostDTO updatePost;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		System.out.println("Inside the create post");
		PostDTO createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
	}

	// get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer userId) {
		List<PostDTO> postsByUser = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDTO>>(postsByUser, HttpStatus.OK);
	}

	// get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDTO> postsByCategory = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(postsByCategory, HttpStatus.OK);
	}

	// get all post
	@GetMapping("/posts")
	public ResponseEntity<PostResponce> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {

		PostResponce postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponce>(postResponse, HttpStatus.OK);
	}

	// get post details by id

	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId) {
		PostDTO postById = this.postService.getPostById(postId);
		return new ResponseEntity<PostDTO>(postById, HttpStatus.OK);
	}

	// Delete post
	@DeleteMapping("/post/{postId}")
	public ApiResponce deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponce("Post Successfully Deleted", true);
	}

	// Update Post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDto, @PathVariable Integer postId) {
		PostDTO updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDTO>(updatePost, HttpStatus.OK);
	}

//	Searching
	@GetMapping("/posts/seach/{keyword}")
	public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable("keyword") String keyword) {
		List<PostDTO> searchPosts = this.postService.searchPosts(keyword);
		return new ResponseEntity<List<PostDTO>>(searchPosts, HttpStatus.OK);
	}

//	Post Image Upload
	@PostMapping("/posts/image/upload/{postId}")
	public ResponseEntity<PostDTO> uploadPostImage(@RequestParam("image") MultipartFile img,
			@PathVariable Integer postId)  {

		PostDTO postDto = this.postService.getPostById(postId);
		String fileName = null;
		try {
			fileName = this.fileService.uploadImage(path, img);
		} catch (IOException e) {
			System.out.println("Error in uploading image !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
	
		postDto.setImageName(fileName);
		
		PostDTO updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDTO>(updatePost, HttpStatus.OK);

	}

    //method to serve files
    @GetMapping(value = "/post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {

        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream())   ;

    }
}

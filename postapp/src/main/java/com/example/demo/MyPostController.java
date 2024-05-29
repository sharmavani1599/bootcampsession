package com.example.demo;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestClient;



@RestController

public class MyPostController {

	

	@GetMapping("/myposts/{id}")

	public Post getMyPost(@PathVariable("id")String id)

	{

		System.out.println(" in get my post "+id);

		String url="https://jsonplaceholder.typicode.com/posts/"+id;

		

		RestClient rc=RestClient.create();

		

		Post response=rc.get()

		.uri(url)

		.retrieve()

		.body(Post.class);

		

		System.out.println("response is "+response.getBody());

		return response;

	}

}
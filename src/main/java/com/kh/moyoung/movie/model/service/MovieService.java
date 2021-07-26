package com.kh.moyoung.movie.model.service;

import java.util.List;

import com.kh.moyoung.movie.model.vo.Movie;
import com.kh.moyoung.review.model.vo.Review;
import com.kh.moyoung.common.util.PageInfo;

public interface MovieService {

	int save(Movie movie);

	int getMovieCount(String title);

	List<Movie> getMovieList(PageInfo pageInfo, String title);

	Movie findByNo(int movieNo);

	List<Movie> selectMovieRecent(PageInfo pageInfo);

	List<Review> selectMovieVote(PageInfo pageInfo);
	
	int getLikeCount(int u_no);
	
	List<Movie> getLikeList(PageInfo pageInfo, int u_no);

	List<Movie> top5List(PageInfo pageInfo);
	
	//List<Movie> getLikeList(PageInfo pageInfo);
}

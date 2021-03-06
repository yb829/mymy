package com.kh.moyoung.movie.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.moyoung.common.util.PageInfo;
import com.kh.moyoung.movie.model.mapper.MovieMapper;
import com.kh.moyoung.movie.model.service.MovieServiceImpl;
import com.kh.moyoung.movie.model.vo.Movie;
import com.kh.moyoung.review.model.vo.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 스프링에서 관리하는 빈으로 등록이 됨
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieMapper mapper;

	@Override
	public int getMovieCount(String title) {
		return mapper.selectMovieCountWithTitle(title);
	}
	
	@Override
	public int getMovieCount() {
		return mapper.selectMovieCount();
	}


	@Override
	public List<Movie> getMovieList(PageInfo pageInfo,String title) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectMovieListWithTitle(rowBounds, title);
	}
	
	@Override
	public List<Movie> getMovieList(PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectMovieList(rowBounds);
	}

	@Override
	@Transactional
	public int save(Movie movie) {
		int result = 0;
		result = mapper.insertMovie(movie);
		return result;
	}

	@Override
	public Movie findByNo(int movieNo) {
		return mapper.selectMovieByNo(movieNo);
	}

	@Override
	public List<Movie> selectMovieRecent(PageInfo pageInfo, String title) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectMovieRecent(rowBounds,title);
	}

	@Override
	public List<Review> selectMovieVote(PageInfo pageInfo, String title) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectMovieVote(rowBounds,title);
	}
	
	@Override
	public int getLikeCount(int u_no) {
		return mapper.selectLikeCount(u_no);
	}
	
	@Override
	public List<Movie> getLikeList(PageInfo pageInfo, int u_no) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		return mapper.selectLikeList(rowBounds, u_no);
	}

	@Override
	public List<Movie> top5List(PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.top5List(rowBounds);
	}

	@Override
	public int getPlatformCount() {
		
		return mapper.selectPlatformCount();
	}

	@Override
	public List<Movie> getNetflixList(PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectNetflixList(rowBounds);
	}

	@Override
	public List<Movie> getWatchaList(PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectWatchaList(rowBounds);
	}

	@Override
	public List<Movie> getTvingList(PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectTvingList(rowBounds);
	}

	@Override
	public List<Movie> getWavveList(PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getListLimit());
		
		return mapper.selectWavveList(rowBounds);
	}
}

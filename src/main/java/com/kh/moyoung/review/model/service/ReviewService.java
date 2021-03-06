package com.kh.moyoung.review.model.service;

import java.util.List;

import com.kh.moyoung.common.util.PageInfo;
import com.kh.moyoung.review.model.vo.Review;

public interface ReviewService {

	int getReviewCount(int movieNo); /* 리뷰 개수 카운팅 */

	List<Review> getReviewList(PageInfo pageInfo, int movieNo); /* 최신 작성순 정렬 */

	List<Review> selectReviewHighRateList(PageInfo pageInfo, int movieNo); /* 평점 높은순 정렬 */
	
	List<Review> selectReviewLowRateList(PageInfo pageInfo, int movieNo); /* 평점 낮은순 정렬 */

	int save(Review review); /* 리뷰 작성하기 */

	int deleteReview(int reviewNo);

	int getMyReviewCount(int u_no);    /* 내 리뷰 카운팅 */

    List<Review> getMyReviewList(PageInfo pageInfo, int u_no);    /* 내 리뷰 리스트 */

}

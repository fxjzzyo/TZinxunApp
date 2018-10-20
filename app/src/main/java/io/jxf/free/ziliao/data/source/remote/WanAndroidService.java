package io.jxf.free.ziliao.data.source.remote;

import java.util.List;

import io.jxf.free.ziliao.data.model.ArticleListResponse;
import io.jxf.free.ziliao.data.model.Banner;
import io.jxf.free.ziliao.data.model.BaseResponse;
import io.jxf.free.ziliao.data.model.Category;
import io.jxf.free.ziliao.data.model.HotKey;
import io.jxf.free.ziliao.data.model.LoginResponse;
import io.jxf.free.ziliao.data.model.NavCategory;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WanAndroidService {
	// 获取首页文章数据
	@GET("article/list/{page}/json")
	Observable<BaseResponse<ArticleListResponse>> getArticles(@Path("page") int page);

	// 获取首页 banner 数据
	@GET("banner/json")
	Observable<BaseResponse<List<Banner>>> getBannerData();

	// 获取项目分类
	@GET("project/tree/json")
	Observable<BaseResponse<List<Category>>> getProjectCategories();

	// 获取项目分类下文章数据
	@GET("project/list/{page}/json")
	Observable<BaseResponse<ArticleListResponse>> getProjectArticles(
			@Path("page") int page, @Query("cid") int cid
	);

	// 获取体系分类
    @GET("tree/json")
    Observable<BaseResponse<List<Category>>> getHierarchyCategories();

   	// 获取体系分类下的文章
    @GET("article/list/{page}/json")
    Observable<BaseResponse<ArticleListResponse>> getHierarchyArticles(
            @Path("page") int page, @Query("cid") int cid
    );

	// 获取导航数据
    @GET("navi/json")
    Observable<BaseResponse<List<NavCategory>>> getNavCategories();

	// 搜索热词
	@GET("hotkey/json")
	Observable<BaseResponse<List<HotKey>>> getHotKey();

	// 搜索
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Observable<BaseResponse<ArticleListResponse>> searchArticles(
            @Path("page") int page, @Field("k") String keyword
    );

    // 登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginResponse>> signin(
    		@Field("username") String username, @Field("password") String password
    );

    // 注册
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<LoginResponse>> signup(
            @Field("username") String username,
            @Field("password") String password,
            @Field("repassword") String repassword
    );
}
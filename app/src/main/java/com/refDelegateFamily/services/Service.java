package com.refDelegateFamily.services;


import com.refDelegateFamily.models.NearbyStoreDataModel;
import com.refDelegateFamily.models.PlaceGeocodeData;
import com.refDelegateFamily.models.PlaceMapDetailsData;
import com.refDelegateFamily.models.UserModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Service {


    @GET("place/details/json")
    Call<NearbyStoreDataModel> getPlaceReview(@Query(value = "placeid") String placeid,
                                              @Query(value = "key") String key
    );

    @GET("place/nearbysearch/json")
    Call<NearbyStoreDataModel> getNearbyStores(@Query(value = "location") String location,
                                               @Query(value = "radius") int radius,
                                               @Query(value = "type") String type,
                                               @Query(value = "language") String language,
                                               @Query(value = "key") String key
    );



    @GET("geocode/json")
    Call<PlaceGeocodeData> getGeoData(@Query(value = "latlng") String latlng,
                                      @Query(value = "language") String language,
                                      @Query(value = "key") String key);

    @GET("place/findplacefromtext/json")
    Call<PlaceMapDetailsData> searchOnMap(@Query(value = "inputtype") String inputtype,
                                          @Query(value = "input") String input,
                                          @Query(value = "fields") String fields,
                                          @Query(value = "language") String language,
                                          @Query(value = "key") String key
    );


    @FormUrlEncoded
    @POST("api/login")
    Call<UserModel> login(@Field("phone_code") String phone_code,
                          @Field("phone") String phone

    );


    @FormUrlEncoded
    @POST("api/drive_register")
    Call<UserModel> signUpWithoutImage(@Field("name") String name,
                                       @Field("email") String email,
                                       @Field("phone_code") String phone_code,
                                       @Field("phone") String phone,
                                       @Field("address") String address,
                                       @Field("user_type") String user_type,
                                       @Field("software_type") String software_type,
                                       @Field("account_bank_number") String account_bank_number,
                                       @Field("ipad_number") String ipad_number,
                                       @Field("nationality_title") String nationality_title,
                                       @Field("car_model") String car_model,
                                       @Field("year_of_manufacture") String year_of_manufacture,
                                       @Field("card_id") String card_id,
                                       @Field("latitude") String latitude,
                                       @Field("longitude") String longitude,
                                       @Field("address_registered_for_bank_account") String address_registered_for_bank_account

    );

    @Multipart
    @POST("api/drive_register")
    Call<UserModel> signUpWithImage(
                                    @Part MultipartBody.Part logo,
                                    @Part MultipartBody.Part licence_image,
                                    @Part MultipartBody.Part back_car_image,
                                    @Part MultipartBody.Part front_car_image,
                                    @Part MultipartBody.Part card_image,
                                    @Part("name") RequestBody name,
                                    @Part("email") RequestBody email,
                                    @Part("phone_code") RequestBody phone_code,
                                    @Part("phone") RequestBody phone,
                                    @Part("address") RequestBody address,
                                    @Part("user_type") RequestBody user_type,
                                    @Part("software_type") RequestBody software_type,
                                    @Part("account_bank_number") RequestBody account_bank_number,
                                    @Part("ipad_number") RequestBody ipad_number,
                                    @Part("nationality_title") RequestBody nationality_title,
                                    @Part("car_model") RequestBody car_model,
                                    @Part("car_type_id") RequestBody car_type_id,
                                    @Part("year_of_manufacture") RequestBody year_of_manufacture,
                                    @Part("card_id") RequestBody card_id,
                                    @Part("latitude") RequestBody latitude,
                                    @Part("longitude") RequestBody longitude,
                                    @Part("address_registered_for_bank_account") RequestBody address_registered_for_bank_account
    );

    @FormUrlEncoded
    @POST("api/update-notifications-status")
    Call<ResponseBody> updateStatus(@Header("Authorization") String user_token,
                                    @Field("user_id") int user_id,
                                    @Field("notification_status") String notification_status

    );
}
package com.codelabs.konspirasisnack.connection;

import androidx.annotation.Nullable;

import com.codelabs.konspirasisnack.model.AbsenceIn;
import com.codelabs.konspirasisnack.model.AbsenceOut;
import com.codelabs.konspirasisnack.model.AddCategory;
import com.codelabs.konspirasisnack.model.AddCustomer;
import com.codelabs.konspirasisnack.model.AddProduct;
import com.codelabs.konspirasisnack.model.CashierClose;
import com.codelabs.konspirasisnack.model.CheckVoucher;
import com.codelabs.konspirasisnack.model.DoPost;
import com.codelabs.konspirasisnack.model.GetCities;
import com.codelabs.konspirasisnack.model.GetCreateOrder;
import com.codelabs.konspirasisnack.model.GetCreateReservation;
import com.codelabs.konspirasisnack.model.GetCustomer;
import com.codelabs.konspirasisnack.model.GetDetailPenjualan;
import com.codelabs.konspirasisnack.model.GetEmployeePosition;
import com.codelabs.konspirasisnack.model.GetEmployee_list;
import com.codelabs.konspirasisnack.model.GetInvoiceNumber;
import com.codelabs.konspirasisnack.model.GetJenisUsaha;
import com.codelabs.konspirasisnack.model.GetKaryawan;
import com.codelabs.konspirasisnack.model.GetKecamatan;
import com.codelabs.konspirasisnack.model.GetLogin;
import com.codelabs.konspirasisnack.model.GetLoginCashier;
import com.codelabs.konspirasisnack.model.GetOpenCashier;
import com.codelabs.konspirasisnack.model.GetOrderByReservation;
import com.codelabs.konspirasisnack.model.GetOrderDetail;
import com.codelabs.konspirasisnack.model.GetOrderListData;
import com.codelabs.konspirasisnack.model.GetOrderListDate;
import com.codelabs.konspirasisnack.model.GetOrderType;
import com.codelabs.konspirasisnack.model.GetOutlet;
import com.codelabs.konspirasisnack.model.GetPaymentMethod;
import com.codelabs.konspirasisnack.model.GetPaymentMethodType;
import com.codelabs.konspirasisnack.model.GetPengaturanPromo;
import com.codelabs.konspirasisnack.model.GetPengaturanVoucher;
import com.codelabs.konspirasisnack.model.GetProductCategory;
import com.codelabs.konspirasisnack.model.GetProductDetail;
import com.codelabs.konspirasisnack.model.GetProducts;
import com.codelabs.konspirasisnack.model.GetProfil;
import com.codelabs.konspirasisnack.model.GetProvince;
import com.codelabs.konspirasisnack.model.GetRefreshToken;
import com.codelabs.konspirasisnack.model.GetRegisterStep1;
import com.codelabs.konspirasisnack.model.GetReportKasKasir;
import com.codelabs.konspirasisnack.model.GetReportKomisi;
import com.codelabs.konspirasisnack.model.GetReportSelling;
import com.codelabs.konspirasisnack.model.GetReportTutupKasir;
import com.codelabs.konspirasisnack.model.GetSetting;
import com.codelabs.konspirasisnack.model.GetStock;
import com.codelabs.konspirasisnack.model.GetStokType;
import com.codelabs.konspirasisnack.model.GetTable;
import com.codelabs.konspirasisnack.model.GetTokenClient;
import com.codelabs.konspirasisnack.model.GetUnits;
import com.codelabs.konspirasisnack.model.GetVoucher;
import com.codelabs.konspirasisnack.model.ParamCreateOrder;
import com.codelabs.konspirasisnack.model.ParamCreateReservation;
import com.codelabs.konspirasisnack.model.PaymentModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetTokenClient)
    Call<GetTokenClient> getTokenClient(@Header(AppConstant.ClientTitle) String authClient, @Header(AppConstant.SecretTitle) String authSecret, @Query("platform") String platform);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.LoginAPI)
    @FormUrlEncoded
    Call<GetLogin> doLogin(@FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.LoginSetting)
    @FormUrlEncoded
    Call<GetRefreshToken> doLoginSetting(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.Me)
    Call<GetProfil> getProfil(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.UpdateProfile)
    @FormUrlEncoded
    Call<GetProfil> updateProfile(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetProducts)
    Call<GetProducts> getProduct(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> param);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetProductCategory)
    Call<GetProductCategory> getProductCategory(@Header(AppConstant.AuthTitle) String auth, @Query("keyword") String category);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetCustomer)
    Call<GetCustomer> getCustomer(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> param);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetFloor)
    Call<GetTable> getTable(@Header(AppConstant.AuthTitle) String auth);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.LoginCashierAPI)
    @FormUrlEncoded
    Call<GetLoginCashier> doLoginCashier(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetEmployeeList)
    Call<GetEmployee_list> getEmployeeList(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.OpenCashier)
    @FormUrlEncoded
    Call<GetOpenCashier> openCashier(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetProductDetail)
    Call<GetProductDetail> getProductDetail(@Header(AppConstant.AuthTitle) String auth, @Path("id") int id, @Query("pricing_by") String keyword, @Query("customer_id") String customer);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetOrderDetail)
    Call<GetOrderDetail> getOrderDetail(@Header(AppConstant.AuthTitle) String auth, @Path("id") int id);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.CreateReservation)
    Call<GetCreateReservation> createReservation(@Header(AppConstant.AuthTitle) String auth, @Body ParamCreateReservation param);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.OrderCreate)
    Call<GetCreateOrder> createOrder(@Header(AppConstant.AuthTitle) String auth, @Body ParamCreateOrder param);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.OrderType)
    Call<GetOrderType> getOrderType(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetOutlet)
    Call<GetOutlet> getOutlet(@Header(AppConstant.AuthTitle) String auth);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.OrderList)
    Call<GetOrderListDate> getOrderListDate(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.OrderList)
    Call<GetOrderListData> getOrderListData(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.PaymentMethod)
    Call<GetPaymentMethod> getPaymentMethod(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.PaymentMethod)
    Call<GetPaymentMethod> getPengaturanPaymentMethod(@Header(AppConstant.AuthTitle) String auth, @Query("payment_type") String payment_type);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetInvoiceNo)
    Call<GetInvoiceNumber> getInvoiceNumber(@Header(AppConstant.AuthTitle) String auth);

//    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
//    @POST(AppConstant.AbsenceIn)
//    @FormUrlEncoded
//    Call<AbsenceIn> absenceIn(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AbsenceIn)
    @Multipart
    Call<AbsenceIn> absenceIn(@Header(AppConstant.AuthTitle) String auth, @PartMap Map<String, RequestBody> partMap, @Part MultipartBody.Part file);

//    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
//    @POST(AppConstant.AbsenceOut)
//    @FormUrlEncoded
//    Call<AbsenceOut> absenceOut(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AbsenceOut)
    @Multipart
    Call<AbsenceOut> absenceOut(@Header(AppConstant.AuthTitle) String auth, @PartMap Map<String, RequestBody> partMap, @Part MultipartBody.Part file);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.CloseCashier)
    @FormUrlEncoded
    Call<CashierClose> closeCashier(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.PaymentPay)
    @FormUrlEncoded
    Call<PaymentModel> paymentPay(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.LogoutApi)
    Call<DoPost> doLogout(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.RegisterApi)
    @FormUrlEncoded
    Call<GetRegisterStep1> doRegister(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.RegisterApiOtp)
    @FormUrlEncoded
    Call<DoPost> doRegisterOtp(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetJenisUsaha)
    Call<GetJenisUsaha> getJenisUsaha(@Header(AppConstant.AcceptTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetProvinces)
    Call<GetProvince> getProvince(@Header(AppConstant.AcceptTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetKecamatan)
    Call<GetKecamatan> getKecamatan(@Header(AppConstant.AcceptTitle) String auth, @Query("city_id") String cityId);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetCities)
    Call<GetCities> getCities(@QueryMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetVoucher)
    Call<GetVoucher> getVoucher(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.VoucherCheck)
    @FormUrlEncoded
    Call<CheckVoucher> voucherCheck(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetUnits)
    Call<GetUnits> getUnits(@Header(AppConstant.AcceptTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.RegisterCompanyInfo)
    @FormUrlEncoded
    Call<DoPost> doRegisterCompany(@Header(AppConstant.AcceptTitle) String auth, @FieldMap Map<String, String> names);

//    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
//    @POST(AppConstant.RegisterProductInfo)
//    @FormUrlEncoded
//    Call<DoPost> doRegisterProduct(@FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.RegisterProductInfo)
    @Multipart
    Call<DoPost> doRegisterProduct(@Header(AppConstant.AcceptTitle) String auth, @PartMap Map<String, RequestBody> partMap, @Part MultipartBody.Part file);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.RefreshTokenAPI)
    Call<GetRefreshToken> refreshToken(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AddCustomer)
    @FormUrlEncoded
    Call<AddCustomer> addCustomer(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AddCategory)
    @FormUrlEncoded
    Call<AddCategory> addCategory(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.EditCategori)
    @FormUrlEncoded
    Call<AddCategory> editCategory(@Header(AppConstant.AuthTitle) String auth, @Path("id") int id, @FieldMap Map<String, String> names);

//    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
//    @POST(AppConstant.AddProduct)
//    @FormUrlEncoded
//    Call<AddProduct> addProduct(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AddProduct)
    @Multipart
    Call<AddProduct> addProduct(@Header(AppConstant.AuthTitle) String auth, @PartMap Map<String, RequestBody> partMap, @Part MultipartBody.Part file);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.EditProduct)
    @Multipart
    Call<AddProduct> editProduct(@Header(AppConstant.AuthTitle) String auth,@Path("id") String id, @PartMap Map<String, RequestBody> partMap, @Nullable @Part MultipartBody.Part file);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetOrderByReservation)
    Call<GetOrderByReservation> getOrderByReservation(@Header(AppConstant.AuthTitle) String auth, @Path("id") int id);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetReportKomisi)
    Call<GetReportKomisi> getReportKomisi(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetReportTutupKasir)
    Call<GetReportTutupKasir> getReportTutupKasir(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetReportKasKasir)
    Call<GetReportKasKasir> getReportKasKasir(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetReportSelling)
    Call<GetReportSelling> getReportSelling(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);


    @GET(AppConstant.GetKaryawan)
    Call<GetKaryawan> getKaryawan(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetPromos)
    Call<GetPengaturanPromo> getPengaturanPromo(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetVouchers)
    Call<GetPengaturanVoucher> getPengaturanVoucher(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.ReportKasKasirAdd)
    @FormUrlEncoded
    Call<DoPost> doAddTransaksiKas(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.EditOutlet)
    @Multipart
    Call<DoPost> editOutlet(@Header(AppConstant.AuthTitle) String auth, @PartMap Map<String, RequestBody> names, @Nullable @Part MultipartBody.Part image);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetSetting)
    Call<GetSetting> getSetting(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.UpdateSetting)
    @FormUrlEncoded
    Call<DoPost> updateSetting(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.PaymentMethodType)
    Call<GetPaymentMethodType> getPaymentMethodType(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetEmployeePosition)
    Call<GetEmployeePosition> getEmployeePosition(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AddPaymentMethod)
    @FormUrlEncoded
    Call<DoPost> addPaymentMethod(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AddEmployee)
    @FormUrlEncoded
    Call<DoPost> addEmployee(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetDetailPenjualan)
    Call<GetDetailPenjualan> getDetailPenjualan(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetStockList)
    Call<GetStock> getStock(@Header(AppConstant.AuthTitle) String auth, @QueryMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @GET(AppConstant.GetSocktype)
    Call<GetStokType> getStockType(@Header(AppConstant.AuthTitle) String auth);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.AddStock)
    @FormUrlEncoded
    Call<DoPost> addStock(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.UpdateStock)
    @FormUrlEncoded
    Call<DoPost> updateStock(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);

    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.EmailPayment)
    @FormUrlEncoded
    Call<DoPost> emailPayment(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


    @Headers({AppConstant.AcceptTitle + ":" + AppConstant.AcceptValue})
    @POST(AppConstant.UpdateOrderStatus)
    @FormUrlEncoded
    Call<DoPost> updateOrderStatus(@Header(AppConstant.AuthTitle) String auth, @FieldMap Map<String, String> names);


}

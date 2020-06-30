package com.codelabs.konspirasisnack.connection;

import androidx.annotation.NonNull;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AppConstant {
    public static final String AuthTitle = "Authorization";
    public static final String AuthValue = "Bearer";
    public static final String AcceptTitle = "Accept";
    public static final String AcceptValue = "application/json";
    public static final String ClientTitle = "X-CLIENT-KEY";
    public static final String ClientValue = "codelabs-android";
    public static final String SecretTitle = "X-SECRET-KEY";
    public static final String SecretValue = "C2z9c9MEjzvxqSbT97NRlR7Q307zSotQ5251";


    //time in miliseconds
    public static final long TIMER_AUTO_LOGOUT = 900000;


    //URL DEV
    public static final String HostAPI = "http://159.65.14.50/pos-cl/pos-cl-gateway/api/v1/";


    public static final String GetTokenClient = "auth/get_token";
    public static final String LoginAPI = "authenticate";
    public static final String LoginSetting = "authenticate/setting";
    public static final String Me = "me";
    public static final String UpdateProfile = "update_profile";
    public static final String GetProducts = "products";
    public static final String GetProductCategory = "product/categories";
    public static final String LoginCashierAPI = "cashier/authenticate";
    public static final String GetCustomer = "customer_all";
    public static final String GetEmployeeList = "employee_list";
    public static final String GetFloor = "floor_all";
    public static final String OpenCashier = "cashier/open";
    public static final String GetProductDetail = "product/show/{id}";
    public static final String CreateReservation = "reservation/create";
    public static final String OrderType = "order/order_type";
    public static final String OrderList = "order/lists";
    public static final String OrderCreate = "order/create";
    public static final String PaymentMethod = "payment/payment_methods";
    public static final String GetInvoiceNo = "order/create_invoice_no";
    public static final String AbsenceIn = "absence_in";
    public static final String AbsenceOut = "absence_out";
    public static final String CloseCashier = "cashier/close";
    public static final String GetOrderDetail = "order/detail/{id}";
    public static final String PaymentPay = "payment/pay";
    public static final String LogoutApi = "auth/logout";
    public static final String GetOutlet = "outlet/lists";
    public static final String RegisterApi = "register";
    public static final String RegisterApiOtp = "register/check_otp";
    public static final String RegisterCompanyInfo = "register/company_info";
    public static final String RegisterProductInfo = "register/product_info";
    public static final String GetJenisUsaha = "merchant/categories";
    public static final String GetProvinces = "provinces";
    public static final String GetCities = "cities";
    public static final String GetVoucher = "vouchers";
    public static final String VoucherCheck = "voucher/check";
    public static final String GetUnits = "units";
    public static final String RefreshTokenAPI ="auth/refresh_token";
    public static final String AddCustomer = "customer/create";
    public static final String AddCategory = "product/category/create";
    public static final String EditCategori = "product/category/update/{id}";
    public static final String AddProduct = "product/create";
    public static final String GetOrderByReservation = "floor/get_order_by_reservation_id/{id}";
    public static final String GetReportKomisi = "report/komisi";
    public static final String GetReportTutupKasir = "report/close_cashier";
    public static final String GetReportKasKasir = "report/kas_cashier";
    public static final String ReportKasKasirAdd = "report/kas_cashier/add";
    public static final String GetReportSelling = "report/selling_summary";
    public static final String EditOutlet = "outlet/update";

    public static final String GetKaryawan = "employee_list";
    public static final String GetPromos = "promos";
    public static final String GetSetting = "setting";
    public static final String UpdateSetting = "setting-update";
    public static final String PaymentMethodType = "payment/payment_method/type";
    public static final String AddPaymentMethod = "payment/payment_method/create";
    public static final String GetEmployeePosition = "get_position";
    public static final String AddEmployee = "employee_add";
    public static final String GetStockList = "stock/lists";
    public static final String GetSocktype = "stock/type";
    public static final String AddStock = "stock/add";
    public static final String UpdateStock = "stock/update";
    public static final String UpdateOrderStatus = "order/update_status";
    public static final String GetDetailPenjualan = "report/transaction_detail";
    public static final String EmailPayment = "payment/email";


    // Global Var
    public static final String DATA_CUSTOMER = "DATA_CUSTOMER";
    public static final String TRANSACTION_ID = "TRANSACTION_ID";
    public static final String ORDER_DETAIL = "ORDER_DETAIL";
    public static final String ORDER_TAMBAHAN_MEJA = "ORDER_MEJA";
    public static final String INVOICE_NUMBER = "INVOICE_NUMBER";

    public static final String MULTIPART_FORM_DATA = "multipart/from-data";
    public static RequestBody createRequestBodyFile(@NonNull File file) {
        return RequestBody.create(
                MediaType.parse(MULTIPART_FORM_DATA), file);
    }

    public static RequestBody createRequestBody(@NonNull String s) {
        return RequestBody.create(
                MediaType.parse(MULTIPART_FORM_DATA), s);
    }
}
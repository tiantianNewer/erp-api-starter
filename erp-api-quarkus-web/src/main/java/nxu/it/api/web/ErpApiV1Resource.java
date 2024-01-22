package nxu.it.api.web;

import nxu.it.api.common.result.ApiPageResult;
import nxu.it.api.common.result.ApiResult;
import nxu.it.api.common.result.Pageable;
import nxu.it.api.common.result.ResponseType;
import nxu.it.model.*;
import nxu.it.service.*;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/v1")
public class ErpApiV1Resource {
    @Inject
    ProductService productService;
    @Inject
    OrderService orderService;
    @Inject
    EmployeeService employeeService;
    @Inject
    CustomerService customerService;
    @Inject
    ShipperService shipperService;
    @Inject
    SupplierService supplierService;
    @Inject
    CategoryService categoryService;

    @Path("/author")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<List<Author>> author() {
        List<Author> authorList = List.of(
                new Author("001", "赵大", 2021, "计科1班"),
                new Author("002", "王二", 2021, "计科2班"),
                new Author("003", "张三", 2021, "计科3班"),
                new Author("004", "李四", 2021, "计科4班")
        );
        return ApiResult.success(authorList);
    }

    @Path("/product/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<List<Product>> productId(@NotNull int id) {
        List<Product> productList = productService.findByProductId(id);
        if (productList.isEmpty()) {
            return ApiResult.fail(ResponseType.NOT_FOUND);
        }
        return ApiResult.success(productList);
    }

    @Path("/products")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Product> products(ProductPageQueryParam productPageQueryParam) {
        Pageable<Product> page = productService.page(productPageQueryParam);
        return ApiPageResult.success(page);
    }
    @Path("/stocks")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Product> stocks(PurchasePageQueryParam purchasePageQueryParam) {
        Pageable<Product> page = productService.purchasePage(purchasePageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/supplier/{id}/products")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Product> pageBySupplierId(@NotNull int id, ProductPageQueryParam productPageQueryParam) {
        Pageable<Product> page = productService.pageBySupplierId(id, productPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/order/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<Order> orderId(@NotBlank String id) {
        Optional<Order> optionalOrder = orderService.findByOrderId(id);
        return ApiResult.success(optionalOrder.orElseThrow(
                () -> new NotFoundException(String.format("订单编号%s不存在",id))
        ));
    }

    @Path("/orders")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Order> orders(OrderPageQueryParam orderPageQueryParam) {
        Pageable<Order> page = orderService.page(orderPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/employee/{id}/orders")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Order> ordersByEmployeeId(@NotBlank String id, OrderPageQueryParam orderPageQueryParam) {
        Pageable<Order> page = orderService.pageByEmployeeId(id, orderPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/customer/{id}/orders")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Order> ordersByCustomerId(@NotNull int id, OrderPageQueryParam orderPageQueryParam) {
        Pageable<Order> page = orderService.pageByCustomerId(id, orderPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/shipper/{id}/orders")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Order> ordersByShipperId(@NotNull int id, OrderPageQueryParam orderPageQueryParam) {
        Pageable<Order> page = orderService.pageByShipperId(id, orderPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/employees")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Employee> employees(EmployeePageQueryParam employeePageQueryParam) {
        Pageable<Employee> page = employeeService.page(employeePageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/customers")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Customer> customers(CustomerPageQueryParam customerPageQueryParam) {
        Pageable<Customer> page = customerService.page(customerPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/shippers")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Shipper> shippers(ShipperPageQueryParam shipperPageQueryParam) {
        Pageable<Shipper> page = shipperService.page(shipperPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/suppliers")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiPageResult<Supplier> suppliers(SupplierPageQueryParam supplierPageQueryParam) {
        Pageable<Supplier> page = supplierService.page(supplierPageQueryParam);
        return ApiPageResult.success(page);
    }

    @Path("/categories/level/{value}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResult<List<Category>> categoriesByLevel(@PathParam("value") @NotNull short level) {
        List<Category> categoryList = categoryService.findByLevel(level);
        return ApiResult.success(categoryList);
    }
}

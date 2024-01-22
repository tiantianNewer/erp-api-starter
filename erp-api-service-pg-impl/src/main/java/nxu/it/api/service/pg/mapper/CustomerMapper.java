package nxu.it.api.service.pg.mapper;

import nxu.it.api.service.pg.entity.CustomerEntity;
import nxu.it.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CustomerMapper {
    Customer toCustomer(CustomerEntity customerEntity);
    List<Customer> toCustomerList(List<CustomerEntity> customerEntityList);
}

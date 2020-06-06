package course.service;

import course.model.Payment;
import java.util.List;

public interface PaymentServiceInter {

    public List<Payment> getPaymentList() throws Exception;
    
    public List<Payment> getSearchPayment(String keyword)throws Exception;

}

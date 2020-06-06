
package course.service;

import course.dao.PaymentDaoInter;
import course.model.Payment;
import java.util.List;

public class PaymentServiceImpl implements PaymentServiceInter{
    
    private PaymentDaoInter paymentDaoInter;

    public PaymentServiceImpl(PaymentDaoInter paymentDaoInter) {
        this.paymentDaoInter=paymentDaoInter;
    }  

    @Override
    public List<Payment> getPaymentList() throws Exception {
        
       return paymentDaoInter.getPaymentList();
    }

    @Override
    public List<Payment> getSearchPayment(String keyword) throws Exception {
        return paymentDaoInter.getSearchPayment(keyword);
    }
    
}

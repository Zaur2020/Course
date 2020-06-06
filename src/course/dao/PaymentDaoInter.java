
package course.dao;

import course.model.Payment;
import java.util.List;


public interface PaymentDaoInter {
    
        public List <Payment> getPaymentList()throws Exception;

        public List<Payment> getSearchPayment(String keyword)throws Exception;

}

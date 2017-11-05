package validator;

import domain.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        //1:使用这种方式，会报错(No message found under code 'empty.user.username.user.username' for locale 'zh_CN'.)，
        // 因为rejectValue的第二个参数都是errorcode
        //errors.rejectValue("username","empty.user.username");
        //errors.rejectValue("username","用户名不能为空");

        //2:正确用法：rejectValue(String filed,String errorcode,Object[] errorArgs,String defaultMessage)
        ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
        ValidationUtils.rejectIfEmpty(errors, "localDate", "localDate.required", "date is required***");
        BigDecimal price = book.getPrice();
        if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
            errors.rejectValue("price", "price.negative", "price cannot be positive****");
        }
        LocalDate localDate = book.getLocalDate();
        if (localDate != null) {
            if (localDate.isAfter(LocalDate.now())) {
                errors.rejectValue("localDate", "localDate.invalid", "date should be valid***");
            }
        }
    }
}

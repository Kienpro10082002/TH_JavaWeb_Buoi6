package doantrungkien.buoi6.quanlyphonghoc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Lấy thông tin lỗi từ request
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        // Kiểm tra loại lỗi và trả về trang lỗi tương ứng
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        // Nếu không phải lỗi 404 hoặc 500 thì trả về trang lỗi mặc định
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}

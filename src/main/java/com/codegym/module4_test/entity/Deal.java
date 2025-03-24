package com.codegym.module4_test.entity;

import com.codegym.module4_test.annotation.ValidUniqueCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "giao_dich")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotEmpty(message = "Mã giao dịch không được để trống")
    @Pattern(regexp = "^MGD-\\d{4}$", message = "Mã giao dịch phải đúng địch dạng MGD-XXXX với X là các số từ 0-9")
    @ValidUniqueCode
    private String code;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "Tên khách hàng không được để trống")
    private Customer customer;

    @Column(name = "deal_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Ngày giao dịch không được để trống")
    @Future(message = "Ngày giao dịch phải lớn hơn này hiện tại")
    private LocalDate dealDate;

    @Column(name = "deal_type")
    @NotNull(message = "Loại dịch vụ không được để trống")
    private Integer dealType;

    @Column(name = "price")
    @NotNull(message = "Đơn giá phải là số và không được để trống")
//    @Pattern(regexp = "^\\d+$", message = "Giá trị phải là số và không chứa ký tự khác")
    @Min(message = "Giá phải ít nhất là 500.000VND", value = 500000)
    private Integer price;

    @Column(name = "acreage")
    @NotNull(message = "Diện tích phải là số và không được để trống")
//    @Pattern(regexp = "^\\d+$", message = "Giá trị phải là số và không chứa ký tự khác")
    @Min(message = "Diện tích tối thiểu là 20m2", value = 20)
    private Integer acreage;
}

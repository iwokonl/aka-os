package pl.aka.os.test.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pl.aka.os.test.dto.CreateFundationAccount.CreateFundationAccountRequestDto;
import pl.aka.os.test.dto.CreateFundationAccount.CreateFundationAccountResponseDto;
import pl.aka.os.test.dto.FinancialReport.FinancialReportResponseDto;
import pl.aka.os.test.service.FundationAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/fundationAccount")
@RequiredArgsConstructor
public class FundationAccountController {

    private final FundationAccountService fundationAccountService;

    @GetMapping("/printFinancialReport")
    public ResponseEntity<FinancialReportResponseDto> printFinancialReport(@RequestParam("fundationAccountId") UUID fundationAccountId) {
        return ResponseEntity.ok(fundationAccountService.printFinancialReport(fundationAccountId));
    }

    @PostMapping("/create")
    public ResponseEntity<CreateFundationAccountResponseDto> createFundationAccount(@RequestBody @Valid CreateFundationAccountRequestDto createFundationAccountRequestDto) {
        return ResponseEntity.ok(fundationAccountService.createFundationAccount(createFundationAccountRequestDto));
    }
}

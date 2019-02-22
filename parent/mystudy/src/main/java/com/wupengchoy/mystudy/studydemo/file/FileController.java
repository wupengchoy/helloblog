package com.wupengchoy.mystudy.studydemo.file;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@Api("文件服务")
@RestController
@RequestMapping("/file")
public class FileController {
    @ApiOperation("文件下载")
    @GetMapping("/download")
    public String downLoadFile(HttpServletResponse response) {
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet();
//        workbook.setSheetName(0, "sheet1");
//        sheet.createRow(0).createCell(0).setCellValue("excel");

        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("src/main/main/resources/测试文档.xlsx");

//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            workbook.write(outputStream);

            response.setContentType("application/vnd.ms-excel;charset=utf-8");

            response.addHeader("Content-Disposition", "attachment;filename=" + "test.xls");
            OutputStream outputStream = response.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, len);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();

//            response.setContentLength(outputStream.size());


//            outputStream.writeTo(response.getOutputStream());
//            outputStream.close();
//            response.getOutputStream().flush();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "0";
    }

    @GetMapping("/test")
    public String justText() {
        return "test";
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf("he".charAt(0)).equals("h"));
    }
}

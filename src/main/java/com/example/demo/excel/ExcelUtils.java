package com.example.demo.excel;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;


import javax.management.OperationsException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author weiqisheng
 * @Title: ExcelUtils
 * @ProjectName utils
 * @Description: TODO
 * @date 2020/12/2316:51
 */
public class ExcelUtils {
    private static List<List<Object>> lineList = new ArrayList<>();

    /**
     *
     * @param response
     * @param fileName 文件名
     * @param projects 数据
     * @param cloumnNames 数据对应的字段
     * @param keys 表头名
     */
    public static void export(HttpServletResponse response,String fileName,List<?> projects,String[] cloumnNames,String[] keys){
        ExcelWriter bigWriter = ExcelUtil.getBigWriter();

        for (int i=0;i<cloumnNames.length;i++){
            bigWriter.addHeaderAlias(cloumnNames[i],keys[i]);
            bigWriter.setColumnWidth(i,20);
        }

        //一次性写出内容，使用默认样式，强制输入标题
        bigWriter.write(projects,true);
        //respose为httpServletResponse对象
       // response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            response.setHeader("Content-Disposition","attachment;filename=" + new String((fileName + ".xlsx").getBytes(),"iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            bigWriter.flush(outputStream,true);
            //关闭writer,释放内存
            bigWriter.close();
            //此处记得关闭servlet流
            IoUtil.close(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param file
     * @return
     */
    public static List<List<Object>> importExcel(MultipartFile file){
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            List<List<Object>> read = reader.read();
            read.remove(0);
            return read;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 标题必须为数据的属性字段
     * @param file
     * @param c
     * @param <T>
     * @return
     */
    public static <T>List<T> importExcel(MultipartFile file,Class c){
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            List list = reader.readAll(c);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 标题必须为数据的属性字段
     * @param file
     * @return
     */
    public static List<Map<String, Object>> importExcel2(MultipartFile file){
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            List<Map<String, Object>> maps = reader.readAll();
            return maps;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

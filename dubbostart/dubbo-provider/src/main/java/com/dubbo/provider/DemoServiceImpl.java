package com.dubbo.provider;

import com.dubbo.start.api.DemoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author single
 * @date 2017/12/24.
 */
public class DemoServiceImpl implements DemoService {

    public List<String> getPermission(Long id) {
        List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d", id - 1));
        demo.add(String.format("Permission_%d", id));
        demo.add(String.format("Permission_%d", id + 1));
        return demo;
    }
}

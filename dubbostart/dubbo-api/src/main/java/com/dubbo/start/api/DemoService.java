package com.dubbo.start.api;

import java.util.List;

/**
 * @author single
 * @date 2017/12/24.
 */
public interface DemoService {
    List<String> getPermission(Long id);
}

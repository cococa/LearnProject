package com.cocoa.dp.proxy_06;

import java.io.File;

public class FileLoaderExecutor implements FileLoader {

    @Override
    public void load(String file) {
        File mFile = new File(file);
        System.out.println(mFile);
    }
}

package com.cocoa.dp.proxy_06;

public class FileLoaderProxy implements FileLoader {

    public FileLoader fileLoader;

    public FileLoaderProxy(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    @Override
    public void load(String file) {
        this.fileLoader.load(file);
    }
}

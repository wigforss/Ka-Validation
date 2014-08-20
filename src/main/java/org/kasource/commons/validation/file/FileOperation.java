package org.kasource.commons.validation.file;

import java.io.File;
import java.io.FileFilter;

public enum FileOperation {
    EXISTING_FILE(new FileFilter(){
        public boolean accept(File file) {
            return file.exists() && file.isFile();
        }}),
    EXISTING_DIRECTORY(new FileFilter(){
            public boolean accept(File file) {
                return file.exists() && !file.isDirectory();
            }}),
    READABLE_FILE(new FileFilter(){
        public boolean accept(File file) {
            return file.exists() && file.isFile() && file.canRead();
        }}),
    WRITABLE_FILE(new FileFilter(){
            public boolean accept(File file) {
                return file.isFile() && file.canWrite();
            }}),
   WRITABLE_EXISTING_FILE(new FileFilter(){
                public boolean accept(File file) {
                    return file.exists() && file.isFile() && file.canWrite();
             }}),
    EXECUTABLE_FILE(new FileFilter(){
            public boolean accept(File file) {
                return file.exists() && file.isFile() && file.canExecute();
            }});
     
    
    private FileFilter filter;
    
    FileOperation(FileFilter filter) {
        this.filter = filter;
    }

    /**
     * @return the filter
     */
    public FileFilter getFilter() {
        return filter;
    }
    
    
}

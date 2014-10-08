package org.kasource.validation.file;

import java.io.File;
import java.io.FileFilter;

public enum FileOperation {
    EXISTING_FILE(new FileFilter(){
        public boolean accept(File file) {
            return file.exists() && file.isFile();
        }},
        "org.kasource.validation.file.FileOperation.EXISTING_FILE"),
    EXISTING_DIRECTORY(new FileFilter(){
            public boolean accept(File file) {
                return file.exists() && file.isDirectory();
            }},
            "org.kasource.validation.file.FileOperation.EXISTING_DIRECTORY"),
    READABLE_FILE(new FileFilter(){
        public boolean accept(File file) {
            return file.exists() && file.isFile() && file.canRead();
        }},
        "org.kasource.validation.file.FileOperation.READABLE_FILE"),
    WRITABLE_FILE(new FileFilter(){
            public boolean accept(File file) {
                return file.isFile() && file.canWrite();
            }},
            "org.kasource.validation.file.FileOperation.WRITABLE_FILE"),
   WRITABLE_EXISTING_FILE(new FileFilter(){
                public boolean accept(File file) {
                    return file.exists() && file.isFile() && file.canWrite();
             }},
             "org.kasource.validation.file.FileOperation.WRITABLE_EXISTING_FILE"),
    EXECUTABLE_FILE(new FileFilter(){
            public boolean accept(File file) {
                return file.exists() && file.isFile() && file.canExecute();
            }},
            "org.kasource.validation.file.FileOperation.EXECUTABLE_FILE");
     
    
    private FileFilter filter;
    private String messageKey;
    
    FileOperation(FileFilter filter, String messageKey) {
        this.filter = filter;
        this.messageKey = messageKey;
    }

    /**
     * @return the filter
     */
    public FileFilter getFilter() {
        return filter;
    }

    /**
     * @return the messageKey
     */
    public String getMessageKey() {
        return messageKey;
    }
    
    
}

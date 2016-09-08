package com.sf.rxjava.sqlite.dbtable;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sf.rxjava.sqlite.db.DbUtils;

@DatabaseTable(tableName = DbUtils.TAB_DOWNLOAD_PROGRAMME_INFO)
public class DownloadBean implements Parcelable {
    /**
     * 主键ID
     */
    @DatabaseField(generatedId = true)
    private Integer id;
    /**
     * 下载id
     */
    @DatabaseField(columnName = "programme_id")
    private int programmeId;
    /**
     * 下载地址
     */
    @DatabaseField(columnName = "programme_url")
    private String programmeUrl;
    /**
     * 标题
     */
    @DatabaseField(columnName = "programme_title")
    private String programmeTitle;
    /**
     * 创建下载的时间
     */
    @DatabaseField(columnName = "create_time")
    private String createTime;
    /**
     * 本地文件保存地址
     */
    @DatabaseField(columnName = "programme_filePath")
    private String programmeFilePath;
    /**
     * 本地文件夹保存地址
     */
    @DatabaseField(columnName = "programme_folderPath")
    private String programmeFolderPath;
    /**
     * 文件下载的类型
     */
    @DatabaseField(columnName = "programme_type")
    private String programmeType;
    /**
     * 文件种类
     */
    @DatabaseField(columnName = "programme_fileKind")
    private int programmeFileKind;
    /**
     * 文件种类
     */
    @DatabaseField(columnName = "programme_fileMd5")
    private String programmeFileMd5;
    /**
     * 文件下载大小
     */
    @DatabaseField(columnName = "fileSize")
    private long fileSize;
    /**
     * 下载进度
     */
    @DatabaseField(columnName = "download_length")
    private long downloadLength;
    /**
     * 当前下载状态
     */
    @DatabaseField(columnName = "download_status")
    private int downloadStatus;
    /**
     * 当前下载线程Id
     */
    @DatabaseField(columnName = "threadId")
    private int threadId;
    /**
     * 开始下载标记
     */
    @DatabaseField(columnName = "download_start_pos")
    private int downloadStartPos;
    /**
     * 结束下载标记
     */
    @DatabaseField(columnName = "download_end_pos")
    private int downloadEndPos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeUrl() {
        return programmeUrl;
    }

    public void setProgrammeUrl(String programmeUrl) {
        this.programmeUrl = programmeUrl;
    }

    public String getProgrammeTitle() {
        return programmeTitle;
    }

    public void setProgrammeTitle(String programmeTitle) {
        this.programmeTitle = programmeTitle;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProgrammeFilePath() {
        return programmeFilePath;
    }

    public void setProgrammeFilePath(String programmeFilePath) {
        this.programmeFilePath = programmeFilePath;
    }

    public String getProgrammeFolderPath() {
        return programmeFolderPath;
    }

    public void setProgrammeFolderPath(String programeFolderPath) {
        this.programmeFolderPath = programeFolderPath;
    }

    public String getProgrammeType() {
        return programmeType;
    }

    public void setProgrammeType(String programeType) {
        this.programmeType = programeType;
    }

    public int getProgrammeFileKind() {
        return programmeFileKind;
    }

    public void setProgrammeFileKind(int programmeFileKind) {
        this.programmeFileKind = programmeFileKind;
    }

    public String getProgrammeFileMd5() {
        return programmeFileMd5;
    }

    public void setProgrammeFileMd5(String programmeFileMd5) {
        this.programmeFileMd5 = programmeFileMd5;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public long getDownloadLength() {
        return downloadLength;
    }

    public void setDownloadLength(long downloadLength) {
        this.downloadLength = downloadLength;
    }

    public int getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(int downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public int getDownloadStartPos() {
        return downloadStartPos;
    }

    public void setDownloadStartPos(int downloadStartPos) {
        this.downloadStartPos = downloadStartPos;
    }

    public int getDownloadEndPos() {
        return downloadEndPos;
    }

    public void setDownloadEndPos(int downloadEndPos) {
        this.downloadEndPos = downloadEndPos;
    }

    public static final Creator<DownloadBean> CREATOR = new Creator<DownloadBean>() {
        @Override
        public DownloadBean createFromParcel(Parcel source) {
            return new DownloadBean(source);
        }

        @Override
        public DownloadBean[] newArray(int size) {
            return new DownloadBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected DownloadBean(Parcel in) {
    }
}

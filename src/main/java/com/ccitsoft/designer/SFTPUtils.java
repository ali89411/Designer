package com.ccitsoft.designer;  
      
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;  

/**
 * <p>Description: [SFTP工具类]</p>
 * Created on 2018年1月16日
 * @author  <a href="mailto: lichao8941188@163.com">ali</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class SFTPUtils {

    /**
     * <p>Discription:[连接服务器，返回ChannelSftp]</p>
     * Created on 2018年1月16日
     * @param host 主机名称
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @return ChannelSftp 对象
     * @author:[ali]
     */
	public ChannelSftp connect(String host, int port, String username, String password) {
		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();  
            jsch.getSession(username, host, port);  
            Session sshSession = jsch.getSession(username, host, port);  
            System.out.println("Session created.");  
            sshSession.setPassword(password);  
            Properties sshConfig = new Properties();  
            sshConfig.put("StrictHostKeyChecking", "no");  
            sshSession.setConfig(sshConfig);  
            sshSession.connect();  
            System.out.println("Session connected.");  
            System.out.println("Opening Channel.");  
            Channel channel = sshSession.openChannel("sftp");  
            channel.connect();  
            sftp = (ChannelSftp) channel;  
            System.out.println("Connected to " + host + ".");  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sftp;
	}

	/**
	 * <p>Discription:[上传文件]</p>
	 * Created on 2018年1月16日
	 * @param directory 上传的目录
	 * @param uploadFile 要上传的文件
	 * @param sftp 服务对象
	 * @author:[ali]
	 */
	public void upload(String directory, String uploadFile, ChannelSftp sftp) {
		try {
			sftp.cd(directory);
			File file = new File(uploadFile);
			sftp.put(new FileInputStream(file), file.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>Discription:[下载文件]</p>
	 * Created on 2018年1月16日
	 * @param directory 下载目录
	 * @param downloadFile 下载的文件
	 * @param saveFile 存在本地的路径
	 * @param sftp 服务对象
	 * @author:[ali]
	 */
	public void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
		try {
			sftp.cd(directory);
			File file = new File(saveFile);
			sftp.get(downloadFile, new FileOutputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>Discription:[删除文件]</p>
	 * Created on 2018年1月16日
	 * @param directory 要删除文件所在目录
	 * @param deleteFile 要删除的文件
	 * @param sftp
	 * @author:[ali]
	 */
	public void delete(String directory, String deleteFile, ChannelSftp sftp) {
		try {
			sftp.cd(directory);
			sftp.rm(deleteFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>Discription:[取得directory的文件列表]</p>
	 * Created on 2018年1月16日
	 * @param directory 要列出的目录
	 * @param sftp 
	 * @return Vector<LsEntry> 对象
	 * @throws SftpException
	 * @author:[ali]
	 */
	@SuppressWarnings("unchecked")
	public Vector<LsEntry> listFiles(String directory, ChannelSftp sftp) throws SftpException {
		return sftp.ls(directory);
	}

	/**
	 * <p>Discription:[关闭session,channel]</p>
	 * Created on 2018年1月16日
	 * @param sftp
	 * @author:[ali]
	 */
	public void closeChannel(ChannelSftp sftp){
		try {
			if(null != sftp.getSession()){
				sftp.getSession().disconnect();
			}
			if(!sftp.isClosed()){
				sftp.disconnect();
			}
		} catch (JSchException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		SFTPUtils sf = new SFTPUtils();
		ChannelSftp sftp = sf.connect("192.168.100.XXX", 22, "root", "XXXX"); // 获取连接
//		sf.upload("/data", "c:\\9月.pdf", sftp); // 上传文件
//        sf.download("/data", "9月.pdf", "c:\\9-1月.pdf", sftp);// 下载文件
        sf.delete("/data", "9月.pdf", sftp);
		Vector<LsEntry> files = sf.listFiles("/data", sftp); // 查看文件列表
		for (LsEntry file : files) {
			System.out.println(file.getFilename());
		}
		
		sftp.isClosed();
	}
}
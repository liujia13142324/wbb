package com.l.wbb.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;

public class MyImageUtil {
	
	public static void main(String args[]) throws IOException, MetadataException, JpegProcessingException {
		String srcname = "D:/mysoft/apache-tomcat-7.0.70/webapps/wbb/upload_wbb/aaaaaa1502595987714.JPG";
		String dstname = "D:/mysoft/apache-tomcat-7.0.70/webapps/wbb/upload_wbb/aaaaaa1502595987714.JPG";
		uploadPicture(new File(srcname), new File(dstname));
	}

	public static void uploadPicture(File srcFile, File dstFile) {
		try {
			BufferedImage src = ImageIO.read(srcFile);
			BufferedImage bi = null;

			// 获取图片旋转角度
			int angel = getRotateAngle(srcFile);
			if (angel == 0) {
				// 图片正常，不处理图片
				bi = src;
			} else {
				// 图片被翻转，调整图片
				bi = doRotate(src, angel);
			}
			Image small =  bi.getScaledInstance(bi.getWidth()/2,bi.getHeight()/2,Image.SCALE_SMOOTH);
			bi = new BufferedImage(bi.getWidth()/2,bi.getHeight()/2, Image.SCALE_DEFAULT);
			Graphics g = bi.getGraphics();  
            g.drawImage(small, 0, 0, null); // 绘制缩小后的图  
            g.dispose();  
			ImageIO.write(bi, "jpg", dstFile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}
	
	public static void uploadPicture(InputStream srcFile, File dstFile) {
		try {
			BufferedImage src = ImageIO.read(srcFile);
			BufferedImage bi = null;

			// 获取图片旋转角度
			int angel = getRotateAngle(srcFile);
			if (angel == 0) {
				// 图片正常，不处理图片
				bi = src;
			} else {
				// 图片被翻转，调整图片
				bi = doRotate(src, angel);
			}
			Image small =  bi.getScaledInstance(bi.getWidth()/2,bi.getHeight()/2,Image.SCALE_SMOOTH);
			bi = new BufferedImage(bi.getWidth()/2,bi.getHeight()/2, Image.SCALE_DEFAULT);
			Graphics g = bi.getGraphics();  
            g.drawImage(small, 0, 0, null); // 绘制缩小后的图  
            g.dispose();  
			ImageIO.write(bi, "jpg", dstFile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}
	

	private static BufferedImage doRotate(BufferedImage src, int angel) {
		int src_width = src.getWidth(null);
		int src_height = src.getHeight(null);
		// calculate the new image size
		Rectangle rect_des = calcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);

		BufferedImage res = null;
		res = new BufferedImage(rect_des.width, rect_des.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = res.createGraphics();
		// transform
		g2.translate((rect_des.width - src_width) / 2, (rect_des.height - src_height) / 2);
		g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);

		g2.drawImage(src, null, null);
		return res;
	}

	private static Rectangle calcRotatedSize(Rectangle src, int angel) {
		// if angel is greater than 90 degree,we need to do some conversion.
		if (angel > 90) {
			if (angel / 9 % 2 == 1) {
				int temp = src.height;
				src.height = src.width;
				src.width = temp;
			}
			angel = angel % 90;
		}

		double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
		double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
		double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
		double angel_dalta_width = Math.atan((double) src.height / src.width);
		double angel_dalta_height = Math.atan((double) src.width / src.height);

		int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
		int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
		int des_width = src.width + len_dalta_width * 2;
		int des_height = src.height + len_dalta_height * 2;
		return new java.awt.Rectangle(new Dimension(des_width, des_height));
	}

	private static int getRotateAngle(File imgFile) {
		int angel = 0;
		Metadata metadata;

		try {
			metadata = JpegMetadataReader.readMetadata(imgFile);
			Directory directory = metadata.getDirectory(ExifIFD0Directory.class);
			if (directory.containsTag(ExifIFD0Directory.TAG_ORIENTATION)) {
				// Exif信息中方向
				int orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
				// 原图片的方向信息
				if (6 == orientation) {
					// 6旋转90
					angel = 90;
				} else if (3 == orientation) {
					// 3旋转180
					angel = 180;
				} else if (8 == orientation) {
					// 8旋转90
					angel = 270;
				}
			}
		} catch (JpegProcessingException e) {
			e.printStackTrace();
		} catch (MetadataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return angel;
	}
	private static int getRotateAngle(InputStream imgFile) {
		int angel = 0;
		Metadata metadata;

		try {
			metadata = JpegMetadataReader.readMetadata(imgFile);
			Directory directory = metadata.getDirectory(ExifIFD0Directory.class);
			if (directory.containsTag(ExifIFD0Directory.TAG_ORIENTATION)) {
				// Exif信息中方向
				int orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
				// 原图片的方向信息
				if (6 == orientation) {
					// 6旋转90
					angel = 90;
				} else if (3 == orientation) {
					// 3旋转180
					angel = 180;
				} else if (8 == orientation) {
					// 8旋转90
					angel = 270;
				}
			}
		} catch (JpegProcessingException e) {
			e.printStackTrace();
		} catch (MetadataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return angel;
	}
	

}

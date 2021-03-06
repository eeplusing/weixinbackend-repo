package com.lixuan.weixin.model;

import java.util.List;

import com.lixuan.weixin.model.Article;

/**
 * 多图文消息，
 * 单图文的时候 Articles 只放一个就行了
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class RespNewsMessage extends RespBaseMessage {
	/**
	 * 图文消息个数，限制为10条以内
	 */
	private int ArticleCount;
	/**
	 * 多条图文消息信息，默认第一个item为大图
	 */
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	public RespNewsMessage(int articleCount, List<Article> articles) {
		super();
		ArticleCount = articleCount;
		Articles = articles;
	}

	public RespNewsMessage() {
		super();
	}
}
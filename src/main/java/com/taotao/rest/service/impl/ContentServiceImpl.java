package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbItem;
import com.taotao.rest.service.ContentService;
import com.taotao.pojo.TbContentExample.Criteria;

/**
 * 内容查询服务service
 * @author wxdsg
 *
 */
@Service
public class ContentServiceImpl implements ContentService{

	@Autowired
	private TbContentMapper tbContentMapper;
	
	/**
	 * 保存新内容
	 */
	@Override
	public TaotaoResult insertContent(TbContent content) {
		// 
		content.setUpdated(new Date());
		content.setCreated(new Date());
		tbContentMapper.insert(content);
		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> getContntList(Long cid) {
		//根据cid查询内容列表
		TbContentExample example=new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<TbContent> list = tbContentMapper.selectByExampleWithBLOBs(example);

		return list;
	}

	/**
	 * 删除内容
	 */
	@Override
	public TaotaoResult deleteContent(Long id) {
		// 
		tbContentMapper.deleteByPrimaryKey(id);
		Long myId=id;
		return TaotaoResult.ok(id);
	}

	@Override
	public TaotaoResult updateContent(TbContent tbContent) {
		if(tbContent==null) {
			
		}
		tbContent.setUpdated(new Date());
		tbContentMapper.updateByPrimaryKey(tbContent);
		return TaotaoResult.ok();
	}
	
}

package com.qf.ttshop.service.impl;

import com.qf.ttshop.common.dto.TreeNode;
import com.qf.ttshop.dao.TbItemCatMapper;
import com.qf.ttshop.pojo.po.TbItemCat;
import com.qf.ttshop.pojo.po.TbItemCatExample;
import com.qf.ttshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: asus
 * Date: 2017/11/23
 * Time: 19:43
 * Version:V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        List<TreeNode> list =null;
        try {
            //创建查询模板
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            //查询商品类别集合
            List<TbItemCat> tbItemCats = itemCatDao.selectByExample(example);
            list = new ArrayList<TreeNode>();
            //拿到商品类别集合中的值
            for (TbItemCat tbItemCat :tbItemCats){
                TreeNode treeNode = new TreeNode();
                treeNode.setId(tbItemCat.getId());
                treeNode.setText(tbItemCat.getName());
                treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
                list.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  list;
    }
}

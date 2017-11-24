package com.qf.ttshop.service;

import com.qf.ttshop.common.dto.TreeNode;

import java.util.List;

/**
 * User: asus
 * Date: 2017/11/23
 * Time: 19:42
 * Version:V1.0
 */
public interface ItemCatService {
    public List<TreeNode> listItemCats(Long parentId);
}

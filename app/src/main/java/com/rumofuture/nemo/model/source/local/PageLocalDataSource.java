package com.rumofuture.nemo.model.source.local;

import android.content.Context;

import com.rumofuture.nemo.app.NemoCallback;
import com.rumofuture.nemo.model.entity.Book;
import com.rumofuture.nemo.model.entity.Page;
import com.rumofuture.nemo.model.source.PageDataSource;

import java.util.List;

import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by WangZhenqi on 2017/4/15.
 */

public class PageLocalDataSource implements PageDataSource {

    private static PageLocalDataSource sInstance;
    private Context mContext;

    public static PageLocalDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new PageLocalDataSource(context);
        return sInstance;
    }

    private PageLocalDataSource(Context context) {
        mContext = context;
    }


    @Override
    public void savePage(Page page, NemoCallback<Page> callback) {

    }

    @Override
    public void deletePage(Page page, NemoCallback<Page> callback) {

    }

    @Override
    public void updatePage(Page page, BmobFile newImage, NemoCallback<Page> callback) {

    }

    @Override
    public void getPageListByBook(Book book, int pageIndex, NemoCallback<List<Page>> callBack) {

    }

    @Override
    public void getPageTotalNumber(Book book, NemoCallback<Integer> callback) {

    }
}

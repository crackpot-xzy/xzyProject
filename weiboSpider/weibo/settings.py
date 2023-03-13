# -*- coding: utf-8 -*-

BOT_NAME = 'weibo'
SPIDER_MODULES = ['weibo.spiders']
NEWSPIDER_MODULE = 'weibo.spiders'
COOKIES_ENABLED = False
TELNETCONSOLE_ENABLED = False
LOG_LEVEL = 'ERROR'
# 访问完一个页面再访问下一个时需要等待的时间，默认为10秒
DOWNLOAD_DELAY = 10
DEFAULT_REQUEST_HEADERS = {
    'Accept':
    'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    'Accept-Language': 'zh-CN,zh;q=0.9,en;q=0.8,en-US;q=0.7',
    # 'cookie': 'your cookie'
    'cookie': 'SINAGLOBAL=2458960222367.4214.1676510733086; UOR=,,cn.bing.com; ULV=1678328029967:6:1:1:1290439360788.7354.1678328029906:1677291995973; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWQZs1wxOwn9f0LZK4Jp3fs5JpX5KMhUgL.FoM0SKz7So-Neoq2dJLoIEnLxK.L1-BL1KeLxKBLB.zL1KBLxKML1h.L1-zLxK-LBK-LBoqEeh24; SSOLoginState=1678606307; SCF=AsM4iOMT-YYcFD2c41TJE8OxTkgot2DSsdkcal5yFg0JTpltfVsGFpYIazpzO9PghjpUayJxKfEhPZ7Yx3OzE44.; SUB=_2A25JCQ-zDeRhGeFN7lAR9ivLyTqIHXVqf2Z7rDV8PUNbmtAGLUz6kW9NQAWQJFX2SkPLCT6e1T5G1NUecxGGlp2e; ALF=1681198305; XSRF-TOKEN=V4ERrSj-IsQE5NxmBvxOGJuf; WBPSESS=n4CtO-4cf-D1vf6U3jJvLveYYIyArLXnEapZNTE97vSqs4wFBxSgkNJFhcSn1kGBVNNYhLbYHEt-LIBK3UTr461MOoffnW6R_ZCTLswCiyh1XFGmgR4bwCs0NkWHq78RF-EMI7p7wbrb5bIopbNIxQ==',
}
ITEM_PIPELINES = {
    'weibo.pipelines.DuplicatesPipeline': 300,
    'weibo.pipelines.CsvPipeline': 301,
    'weibo.pipelines.MysqlPipeline': 302,
}
# 关键词列表，可写多个, 值可以是由关键词或话题组成的列表，也可以是包含关键词的txt文件路径，
# 如'keyword_list.txt'，txt文件中每个关键词占一行
KEYWORD_LIST = ['考研']  # 或者 KEYWORD_LIST = 'keyword_list.txt'
# 搜索的微博类型，0代表搜索全部微博，1代表搜索全部原创微博，2代表热门微博，3代表关注人微博，4代表认证用户微博，5代表媒体微博，6代表观点微博
WEIBO_TYPE = 1
# 筛选结果微博中必需包含的内容，0代表不筛选，获取全部微博，1代表搜索包含图片的微博，2代表包含视频的微博，3代表包含音乐的微博，4代表包含短链接的微博
CONTAIN_TYPE = 0
# 筛选微博的发布地区，精确到省或直辖市，值不应包含“省”或“市”等字，如想筛选北京市的微博请用“北京”而不是“北京市”，想要筛选安徽省的微博请用“安徽”而不是“安徽省”，可以写多个地区，
# 具体支持的地名见region.py文件，注意只支持省或直辖市的名字，省下面的市名及直辖市下面的区县名不支持，不筛选请用“全部”
REGION = ['全部']
# 搜索的起始日期，为yyyy-mm-dd形式，搜索结果包含该日期
START_DATE = '2023-03-09'
# 搜索的终止日期，为yyyy-mm-dd形式，搜索结果包含该日期
END_DATE = '2023-03-11'
# 进一步细分搜索的阈值，若结果页数大于等于该值，则认为结果没有完全展示，细分搜索条件重新搜索以获取更多微博。数值越大速度越快，也越有可能漏掉微博；数值越小速度越慢，获取的微博就越多。
# 建议数值大小设置在40到50之间。
FURTHER_THRESHOLD = 46
# MySQL配置
MYSQL_HOST = 'localhost'
MYSQL_PORT = 3306
MYSQL_USER = 'root'
MYSQL_PASSWORD = '123456'
MYSQL_DATABASE = 'myproject'

#scrapy crawl search
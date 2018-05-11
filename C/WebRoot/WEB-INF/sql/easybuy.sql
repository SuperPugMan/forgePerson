/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-07 18:52:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `easybuy_news`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_news`;
CREATE TABLE `easybuy_news` (
  `module` varchar(50) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(40) NOT NULL COMMENT '标题',
  `content` varchar(1000) NOT NULL COMMENT '内容',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C63B5EE724927208` (`id`),
  UNIQUE KEY `UQ__EASYBUY___C12AD09D276EDEB3` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=722 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_news
-- ----------------------------
INSERT INTO `easybuy_news` VALUES (null, '701', '最新酷睿笔记本711', '新酷睿双核处理器，保证CPU更高效的运转。', '2018-04-25 18:27:21', null);
INSERT INTO `easybuy_news` VALUES ('心健新闻', '718', '真的好棒111', '1111', '2018-05-02 10:24:23', '1525227863700.png');
INSERT INTO `easybuy_news` VALUES (null, '719', '真的好棒ssss', '112122121sss', '2018-05-01 09:31:00', '');
INSERT INTO `easybuy_news` VALUES ('心健新闻', '721', '333331113', 'eeeeee', '2018-05-02 10:19:27', '1525227567094.png');

-- ----------------------------
-- Table structure for `easybuy_order`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order`;
CREATE TABLE `easybuy_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(255) DEFAULT NULL COMMENT '用户主键',
  `loginName` varchar(255) DEFAULT NULL,
  `userAddress` varchar(255) DEFAULT NULL COMMENT '用户地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `cost` float DEFAULT NULL COMMENT '总消费',
  `serialNumber` varchar(255) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_order
-- ----------------------------
INSERT INTO `easybuy_order` VALUES ('2', '18', 'shangzezhong', '北京市海淀区成府路', '2016-06-02 14:52:49', '8596', '8EF5E1557D55413781658A65FC301B8A');
INSERT INTO `easybuy_order` VALUES ('3', '2', 'admin', '北京市海淀区大有庄', '2016-06-03 11:41:09', '456', '51718726C1274CC59504AB4E6FD64BA0');

-- ----------------------------
-- Table structure for `easybuy_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order_detail`;
CREATE TABLE `easybuy_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderId` int(10) NOT NULL COMMENT '订单主键',
  `productId` int(10) NOT NULL COMMENT '商品主键',
  `quantity` int(10) NOT NULL COMMENT '数量',
  `cost` float NOT NULL COMMENT '消费',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___66E1BD8E2F10007B` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_order_detail
-- ----------------------------
INSERT INTO `easybuy_order_detail` VALUES ('1', '1', '733', '5', '760');
INSERT INTO `easybuy_order_detail` VALUES ('2', '1', '734', '4', '608');
INSERT INTO `easybuy_order_detail` VALUES ('3', '1', '735', '1', '152');
INSERT INTO `easybuy_order_detail` VALUES ('4', '1', '738', '1', '45');
INSERT INTO `easybuy_order_detail` VALUES ('5', '1', '739', '1', '156');
INSERT INTO `easybuy_order_detail` VALUES ('6', '2', '755', '1', '8596');
INSERT INTO `easybuy_order_detail` VALUES ('7', '3', '733', '1', '152');
INSERT INTO `easybuy_order_detail` VALUES ('8', '3', '734', '1', '152');
INSERT INTO `easybuy_order_detail` VALUES ('9', '3', '735', '1', '152');

-- ----------------------------
-- Table structure for `easybuy_product`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product`;
CREATE TABLE `easybuy_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `price` float NOT NULL COMMENT '价格',
  `stock` int(10) NOT NULL COMMENT '库存',
  `categoryLevel1Id` int(10) DEFAULT NULL COMMENT '分类1',
  `categoryLevel2Id` int(10) DEFAULT NULL COMMENT '分类2',
  `categoryLevel3Id` int(10) DEFAULT NULL COMMENT '分类3',
  `fileName` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1：删除 0：未删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___94F6E55132E0915F` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=771 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product
-- ----------------------------
INSERT INTO `easybuy_product` VALUES ('733', '香奈儿', '订单', '521', '94', '548', '654', '655', '27A1789ED5764D82A5506DF3DC3933F9.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('734', '洗面奶', '', '152', '995', '548', '654', '655', 'D6C9BD438C5643D6B1A6C52E5426FE22.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('735', '啫喱水', '', '152', '998', '548', '654', '655', '1A836D2B3A3348DDAB19807E6CEA8028.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('736', '香水5852', '', '152', '1000', '548', '654', '655', '4D9499BAD92A42D291094E797BA2EA3F.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('737', '香水', '', '152', '111', '548', '654', '655', 'A9924F9DB68B4DF99FDBF05902075AF0.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('738', '润肤露', '', '45', '109', '548', '654', '655', '3B059EDB5237407980458CE9EA9D3204.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('739', '洁面装', '', '156', '99', '548', '654', '655', 'A62C6DF55116440CA3DE9DB37901ED4F.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('740', '电饭锅', '', '158', '100', '628', '656', '659', '40C3B76BA31246618E3CFC8723D33517.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('741', '婴儿喂奶装', '', '569', '100', '632', '637', '653', '401004B3D47C4C6FB1BC5EF19C21FC77.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('742', '坚果套餐', '', '158', '1000', '660', '661', '662', 'E03D74145A034F6D909879829CB99D80.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('743', '超甜蜜崭', '', '589', '1000', '660', '661', '663', '7121E55099FC477680B1229205CE3D29.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('744', '华为2566', '', '589', '1000', '670', '671', '672', 'F24B4140A2284B3788A38F3B5AD1809A.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('745', '荣耀3C', '', '589', '100', '670', '671', '672', 'F3921E12552A4D0AA3F75467B146A959.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('746', '小米手环', '', '963', '100', '670', '674', '675', '72F75A371B0B4C26A7F72FAAEF96FC68.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('747', '华为2265', '', '896', '1000', '670', '671', '673', '161F355A8A8549BA8F7F4CE3B4F07E40.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('748', '越南坚果', '', '520', '1000', '660', '661', '662', 'CBC98D3C9E544830821632F5C313D93E.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('749', '日本进口马桶', '', '5866', '100', '628', '657', '0', 'A5AF40825E6940B2A59A040100E181A8.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('750', '联想Y系列', '', '569', '1000', '670', '690', '691', '956DB0BEC41B41B8A06C05C950130E23.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('751', '脑白金1号', '', '589', '1000', '676', '677', '680', '66E96AF9E9714A5C9EA901811173D662.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('752', '莫里斯按', '', '589', '1000', '676', '678', '0', 'A7436BC607E74C81B392DCFE69D4AEAB.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('753', '三鹿好奶粉', '', '859', '100', '676', '679', '0', '3C465E7B8A324A8DA2A2EEE202E36166.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('754', '儿童牛奶', '', '5896', '100', '676', '679', '0', 'D1AC9AE71ED348FA8D880FD4279D3422.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('755', '软沙发', '', '8596', '99', '628', '696', '0', 'ED7921DE40FC47E18365754709A21194.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('756', '收纳盒', '', '5966', '100', '628', '696', '0', 'DB86CA25CA4F4B4AA906F46BE542C6A6.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('757', '洗衣液', '', '58', '1000', '628', '696', '0', 'E6CCDC343ACC471C908E9748776C6421.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('758', '红短沙发', '', '596', '123', '628', '696', '0', 'BD5C77465DC2466BBCE7F95FB9764392.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('759', '新西兰奶粉', '', '5896', '100', '676', '679', '0', '9ED375098D42497B8FC33167E06D0EE8.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('760', '婴儿车', '', '11000', '100', '681', '682', '687', '1DBC0930641D43C29D74A9E1B40FEEBB.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('761', '夏款婴儿车', '', '963', '100', '681', '682', '688', '16290C4DBEAC4F00A636667019621468.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('762', '抗压旅行箱', '', '569', '1000', '681', '683', '685', '272CC434BE7A4469AB0E7882BD1A85FF.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('763', '透明手提箱', '', '8596', '1000', '681', '683', '684', 'EAA8E66259BF4239B4A2237B62520EF1.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('764', '婴儿果粉', '', '5896', '1000', '660', '661', '662', '08BE30BF7B5F4930B0093D8CC4056057.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('765', '椰子粉', '', '5963', '1000', '660', '661', '662', '9C006B8BD1AD45398F474A8471ADC50B.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('766', '坚果蛋糕', '', '200', '100', '660', '661', '663', '2E5A16E21E0640E0BAE03E9B995DCD28.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('767', '编制手提箱', '', '5896', '1000', '681', '682', '688', '2E1D2A5E65A94FEEA17C72E47C530057.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('768', '纸箱', '', '5896', '100', '681', '682', '687', '443E5A4122064209AFE89250179A2FF0.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('769', '健胃液', '', '152', '1000', '676', '679', '0', '30B5547CD7384DAA8A2F4F4D8C0BBF89.jpg', '0');
INSERT INTO `easybuy_product` VALUES ('770', '联想NTC', '', '8596', '100', '670', '671', '673', '48BC371A85A548B7A7589E3F542D911D.jpg', '0');

-- ----------------------------
-- Table structure for `easybuy_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product_category`;
CREATE TABLE `easybuy_product_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `parentId` int(10) NOT NULL COMMENT '父级目录id',
  `type` int(11) DEFAULT NULL COMMENT '级别(1:一级 2：二级 3：三级)',
  `iconClass` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___9EC2A4E236B12243` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product_category
-- ----------------------------
INSERT INTO `easybuy_product_category` VALUES ('548', '化妆品', '0', '1', '');
INSERT INTO `easybuy_product_category` VALUES ('628', '家用商品', '0', '1', '');
INSERT INTO `easybuy_product_category` VALUES ('654', '面部护理', '548', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('655', '少女派', '654', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('656', '餐具', '628', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('657', '卫具', '628', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('658', '叉子', '656', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('659', '锅', '656', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('660', '进口食品,生鲜', '0', '1', '');
INSERT INTO `easybuy_product_category` VALUES ('661', '零食/糖果/巧克力', '660', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('662', '坚果', '661', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('663', '蜜饯', '661', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('669', '孕期教育', '546', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('670', '电子商品', '0', '1', '');
INSERT INTO `easybuy_product_category` VALUES ('671', '手机', '670', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('672', '华为手机', '671', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('673', '联想手机', '671', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('674', '手环', '670', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('675', '小米手环', '674', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('676', '保健食品', '0', '1', '');
INSERT INTO `easybuy_product_category` VALUES ('677', '老年保健品', '676', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('678', '中年营养品', '676', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('679', '儿童保健品', '676', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('680', '脑白金', '677', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('681', '箱包', '0', '1', '');
INSERT INTO `easybuy_product_category` VALUES ('682', '旅行箱', '681', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('683', '手提箱', '681', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('684', '大型', '683', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('685', '小型', '683', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('686', '中型', '683', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('687', '大型', '682', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('688', '中型', '682', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('689', '小型', '682', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('690', '电脑', '670', '2', '');
INSERT INTO `easybuy_product_category` VALUES ('691', '联想电脑', '690', '3', '');
INSERT INTO `easybuy_product_category` VALUES ('692', '刀叉', '656', '3', null);
INSERT INTO `easybuy_product_category` VALUES ('693', '碗筷', '656', '3', null);
INSERT INTO `easybuy_product_category` VALUES ('696', '客厅专用', '628', '2', '');

-- ----------------------------
-- Table structure for `easybuy_user`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` varchar(255) NOT NULL COMMENT '登录名',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `sex` int(2) DEFAULT '1' COMMENT '性别(1:男 0：女)',
  `identityCode` varchar(60) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(80) NOT NULL COMMENT '邮箱',
  `mobile` varchar(11) NOT NULL COMMENT '手机',
  `type` int(2) DEFAULT '0' COMMENT '类型（1：后台 0:前台）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C96109CC3A81B327` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_user
-- ----------------------------
INSERT INTO `easybuy_user` VALUES ('111', 'qq', '云购物 ', 'E444BBC51CDCCC579EF29078CB6BB3C629C10714E8574DDE6147B768', '1', null, '111@qq.com', '13500222222', '1');
INSERT INTO `easybuy_user` VALUES ('112', 'qq1', null, '6845B63070D39DE0119D64FA298B7BA3BD8DC85E403888EE655B3DC7', '1', null, '11122121@qq.com', '13533333333', '1');
INSERT INTO `easybuy_user` VALUES ('113', 'qq2', null, 'BBEA96DF7DAF012067229421C89426CF238E9F42D1E504B1EF838A40', '1', null, '11331@qq.com', '13519191919', '0');
INSERT INTO `easybuy_user` VALUES ('114', 'qq3', null, '0415C3DA608FA8EC5BF3472ECAEA437B30D8F20FAB940DEAF9F5BACC', '1', null, '1132221@qq.com', '13522277711', '0');
INSERT INTO `easybuy_user` VALUES ('115', 'qq4', null, 'BC191ABE04A5F051C27828D461FE32600156CB7815EF8F895E1DCE6E', '1', null, '112323121@qq.com', '13566363632', '0');
INSERT INTO `easybuy_user` VALUES ('116', 'qq5', null, '7B4C3BF9D34CD565C280F8760A4F982870D7C5316CB4C7D04CEF7218', '1', null, '117766776@qq.com', '13500055533', '0');
INSERT INTO `easybuy_user` VALUES ('117', 'eee11', null, '90AE2D56D92330D3271FDACDC0C572CED14DA4B18A05976C2E2323DB', '1', null, '11111!@qq.com', '13566666666', '0');
INSERT INTO `easybuy_user` VALUES ('118', 'qqq1', null, 'D7C93B7B9992DB4D9AE996D1D30D2F6A51C1FA6079C64D77FECC0E80', '1', null, '111311@qq.com', '13547474747', '0');
INSERT INTO `easybuy_user` VALUES ('119', 'wwww12', null, '0A38F447653FB4D762588CFC8C0FBA0CBF9A5BD795C06FD9F32228A1', '1', null, '13232323@qq.com', '1352221111', '0');
INSERT INTO `easybuy_user` VALUES ('121', 'qqqqqqq1', null, '389F86F46D7B0E62379867068EF8198C5723B0F36BF430D928BA9526', '1', null, '565665@qq.com', '13577777772', '0');
INSERT INTO `easybuy_user` VALUES ('123', 'gggggs1', null, '72C30C1387083F85C7F96E18FC11E4CEDF11578513938D22B99ABCC3', '1', null, '232243477@qq.com', '13522666222', '0');
INSERT INTO `easybuy_user` VALUES ('125', 'trtrtrt', null, '41A3B75430224BE9F40919FDF64EFDF579635D2D3D3209EEBC848043', '1', null, '66565@qq.com', '13577575755', '0');
INSERT INTO `easybuy_user` VALUES ('127', 'qq213121', null, 'EEF8BDEADDD9E8F2FE0E1D45D0F37448F097BDD4C617F9E7F8CA3EDA', '1', null, '123456@qq.com', '13544323232', '0');
INSERT INTO `easybuy_user` VALUES ('128', '4422', null, 'CB175D91BB22410186035F9D22357ACC4E721C0A59254549C6561559', '1', null, '323433423@qq.com', '13588844444', '0');
INSERT INTO `easybuy_user` VALUES ('129', 'www', '刘兴业444', '00961B35325BE8FD3252A475A24B25BEA66B8E64EC62561A7DAD0DA5', '1', null, '2376767@qq.com', '13566644444', '0');
INSERT INTO `easybuy_user` VALUES ('130', '124', '嗯嗯哒房产税的', '0AD47B4340621BBDC19313878F8F36048632EE57FBD041C000F0C91F', '1', null, '777777@qq.com', '15212333', '0');
INSERT INTO `easybuy_user` VALUES ('131', '123qq', '333333', '25C9C6C0EBFE44D3FA9CB0DF622B7F51F9D64333B77E9445581F11A1', '1', null, '11221@qq.com', '1356666222', '0');

-- ----------------------------
-- Table structure for `easybuy_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user_address`;
CREATE TABLE `easybuy_user_address` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userId` int(255) DEFAULT NULL COMMENT '用户主键',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `isDefault` int(2) DEFAULT '0' COMMENT '是否是默认地址（1:是 0否）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_user_address
-- ----------------------------
INSERT INTO `easybuy_user_address` VALUES ('11', '2', '北京市海淀区大有庄', null, '0', '朋友家');
INSERT INTO `easybuy_user_address` VALUES ('12', '2', '北京市海淀区大有庄', null, '0', '女朋友公司');
INSERT INTO `easybuy_user_address` VALUES ('13', '9', '北京市西直门大桥芬兰国际大厦', null, '0', '女朋友地址');
INSERT INTO `easybuy_user_address` VALUES ('14', '18', '北京市花园路小区', null, '0', '家里');
INSERT INTO `easybuy_user_address` VALUES ('15', '18', '北京市海淀区成府路', null, '0', '公司');

-- ----------------------------
-- Table structure for `shopping_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `userId` int(4) NOT NULL COMMENT '用户Id',
  `productId` int(4) NOT NULL COMMENT '商品Id',
  `productNum` int(10) NOT NULL COMMENT '商品数量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('131', '739', '10');
INSERT INTO `shopping_cart` VALUES ('131', '750', '5');
INSERT INTO `shopping_cart` VALUES ('131', '760', '8');
INSERT INTO `shopping_cart` VALUES ('131', '734', '16');
INSERT INTO `shopping_cart` VALUES ('131', '735', '1');
INSERT INTO `shopping_cart` VALUES ('131', '742', '5');
INSERT INTO `shopping_cart` VALUES ('131', '762', '6');
INSERT INTO `shopping_cart` VALUES ('131', '744', '1');
INSERT INTO `shopping_cart` VALUES ('131', '762', '100');
INSERT INTO `shopping_cart` VALUES ('111', '770', '100');

<template>
    <el-menu
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            :default-active="activeIndex"
            router
    >
       <NavSubMenu :navMenus="menuData"></NavSubMenu>
    </el-menu>
</template>

<script>
    import NavSubMenu from "@/components/NavSubMenu";
export default {
    components: {
        NavSubMenu: NavSubMenu
    },
    name: 'NavMenu',
    props: ['navMenus'],
    data() {
        return {
            activeIndex: 'aa',
            menuData: [
                {
                    //一级
                    entity: {
                        id: 0,
                        name: "aa",
                        icon: "el-icon-message",
                        alias: "首页"
                    }
                },
                {
                    //一级
                    entity: {
                        id: 1,
                        name: "systemManage",
                        icon: "el-icon-message",
                        alias: "两级菜单"
                    },
                    //二级
                    childs: [
                        {
                            entity: {
                                id: 3,
                                name: "authManage",
                                icon: "el-icon-loading",
                                alias: "权限管理",
                                value: { path: "/hello" }
                            }
                        },
                        {
                            entity: {
                                id: 4,
                                name: "roleManage",
                                icon: "el-icon-bell",
                                alias: "角色管理",
                                value: "/system/role"
                            }
                        },
                        {
                            entity: {
                                id: 2,
                                name: "menuManage",
                                icon: "el-icon-edit",
                                alias: "菜单管理",
                                value: "/system/menu"
                            }
                        },
                        {
                            entity: {
                                id: 5,
                                name: "groupManage",
                                icon: "el-icon-mobile-phone\r\n",
                                alias: "分组管理",
                                value: "/system/group"
                            }
                        }
                    ]
                },
                {
                    //一级
                    entity: {
                        id: 6,
                        name: "userManage",
                        icon: "el-icon-news",
                        alias: "三级菜单"
                    },
                    //二级
                    childs: [
                        {
                            entity: {
                                id: 7,
                                name: "accountManage",
                                icon: "el-icon-phone-outline\r\n",
                                alias: "帐号管理",
                                value: ""
                            },
                            //三级
                            childs: [
                                {
                                    entity: {
                                        id: 14,
                                        name: "emailManage",
                                        icon: "el-icon-sold-out\r\n",
                                        alias: "邮箱管理",
                                        value: "/content/email"
                                    }
                                },
                                {
                                    entity: {
                                        id: 13,
                                        name: "passManage",
                                        icon: "el-icon-service\r\n",
                                        alias: "密码管理",
                                        value: "/content/pass"
                                    }
                                }
                            ]
                        },
                        {
                            entity: {
                                id: 8,
                                name: "integralManage",
                                icon: "el-icon-picture",
                                alias: "积分管理",

                                value: "/user/integral"
                            }
                        }
                    ]
                },
                {
                    //一级
                    entity: {
                        id: 40,

                        name: "contentManage",
                        icon: "el-icon-rank",
                        alias: "四级菜单"
                    },
                    //er级
                    childs: [
                        {
                            entity: {
                                id: 41,
                                name: "classifyManage2",
                                icon: "el-icon-printer",
                                alias: "分类管理"
                            },
                            //三级
                            childs: [
                                {
                                    entity: {
                                        id: 42,
                                        name: "classifyManage3",
                                        icon: "el-icon-printer",
                                        alias: "分类管理"
                                    },
                                    //四级
                                    childs: [
                                        {
                                            entity: {
                                                id: 43,
                                                name: "classifyManage4",
                                                icon: "el-icon-printer",
                                                alias: "分类管理",
                                                value: "/content/classify"
                                            }
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        };
    },
    methods: {}
    }
</script>

<style>
    /* 水平样式 */
    .el-menu--horizontal>div>.el-submenu {
        float: left;
    }
    /* 一级菜单的样式 */
    .el-menu--horizontal>div>.el-menu-item {
        float: left;
        height: 60px;
        line-height: 60px;
        margin: 0;
        border-bottom: 2px solid transparent;
        color: #909399;
    }
    /* 解决下图1 下拉三角图标 */
    .el-menu--horizontal>div>.el-submenu .el-submenu__icon-arrow {
        position: static;
        vertical-align: middle;
        margin-left: 8px;
        margin-top: -3px;
    }
    /* 解决下图2 无下拉菜单时 不对齐问题 */
    .el-menu--horizontal>div>.el-submenu .el-submenu__title {
        height: 60px;
        line-height: 60px;
        border-bottom: 2px solid transparent;
        color: #909399;
    }


</style>

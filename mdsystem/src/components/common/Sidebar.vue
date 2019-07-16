<template>
    <div class="sidebar">
        <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#324157"
            text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu v-if="subItem.subs" :index="subItem.index" :key="subItem.index">
                                <template slot="title">{{ subItem.title }}</template>
                                <el-menu-item v-for="(threeItem,i) in subItem.subs" :key="i" :index="threeItem.index">
                                    {{ threeItem.title }}
                                </el-menu-item>
                            </el-submenu>
                            <el-menu-item v-else :index="subItem.index" :key="subItem.index">
                                {{ subItem.title }}
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
    import bus from '../common/bus';

    export default {

        data() {
            let username = localStorage.getItem('ms_username');
            if (username!='admin') {
                return {
                    collapse: false,
                    items: [

                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'kehutable',
                            title: '客户信息'
                        },
                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'kehulbtable',
                            title: '客户类别'
                        },

                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'mdtable',
                            title: '药品信息',
                        },
                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'mdggtable',
                            title: '药品规格'
                        },

                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'ywtable',
                            title: '业务申请'
                        },
                        {
                            icon: 'el-icon-pie-chart',
                            index: 'charts',
                            title: 'schart图表'
                        }

                    ]
                }
            }
            else {
                return {
                    collapse: false,
                    items: [
                        {
                            icon: 'el-icon-lx-home',
                            index: 'dashboard',
                            title: '系统首页'
                        },
                        // {
                        //     icon:'el-icon-lx-cascades',
                        //     index:'kehutable',
                        //     tltle:'客户表'
                        // },

                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'table',
                            title: '基础表格'
                        },
                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'kehutable',
                            title: '客户表'
                        },
                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'kehulbtable',
                            title: '客户类别表'
                        },
                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'usertable',
                            title: '用户表'
                        },
                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'mdtable',
                            title: '药品表',
                            // subs: [
                            //     {
                            //         index: 'drag',
                            //         title: '拖拽列表',
                            //     },
                            //     {
                            //         index: 'dialog',
                            //         title: '拖拽弹框',
                            //     }
                            // ]
                        },
                        // {
                        //     icon: 'el-icon-lx-cascades',
                        //     index: 'mdtable',
                        //     title: '药品表',
                        //     // subs: [
                        //     //     {
                        //     //         index: 'drag',
                        //     //         title: '拖拽列表',
                        //     //     },
                        //     //     {
                        //     //         index: 'dialog',
                        //     //         title: '拖拽弹框',
                        //     //     }
                        //     // ]
                        // },

                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'mdggtable',
                            title: '药品规格表'
                        },
                        {
                            icon: 'el-icon-lx-cascades',
                            index: 'passtable',
                            title: '流向数据表',
                            // subs: [
                            //     {
                            //         index: 'permission',
                            //         title: '权限测试'
                            //     },
                            //     {
                            //         index: '404',
                            //         title: '404页面'
                            //     }
                            // ]
                        },
                        {
                            icon: 'el-icon-lx-calendar',
                            index: '3',
                            title: '表单相关',
                            subs: [
                                {
                                    index: 'form',
                                    title: '基本表单'
                                },
                                {
                                    index: '3-2',
                                    title: '三级菜单',
                                    subs: [
                                        {
                                            index: 'editor',
                                            title: '富文本编辑器'
                                        },
                                        {
                                            index: 'markdown',
                                            title: 'markdown编辑器'
                                        },
                                    ]
                                },
                                {
                                    index: 'upload',
                                    title: '文件上传'
                                }
                            ]
                        },

                        {
                            icon: 'el-icon-pie-chart',
                            index: 'charts',
                            title: 'schart图表'
                        }


                    ]
                }
            }
        },
        computed:{
            onRoutes(){
                return this.$route.path.replace('/','');
            }
        },
        created(){
            // 通过 Event Bus 进行组件间通信，来折叠侧边栏
            bus.$on('collapse', msg => {
                this.collapse = msg;
            })
        }
    }
</script>

<style scoped>
    .sidebar{
        display: block;
        position: absolute;
        left: 0;
        top: 70px;
        bottom:0;
        overflow-y: scroll;
    }
    .sidebar::-webkit-scrollbar{
        width: 0;
    }
    .sidebar-el-menu:not(.el-menu--collapse){
        width: 250px;
    }
    .sidebar > ul {
        height:100%;
    }
</style>

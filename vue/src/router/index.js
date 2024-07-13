import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},








	// 操作人员路由
	{
		path: '/operator/table',
		name: 'operator_table',
		component: () => import('../views/operator/table.vue'),
		meta: {
			index: 0,
			title: '操作人员列表'
		}
	},
	{
		path: '/operator/view',
		name: 'operator_view',
		component: () => import('../views/operator/view.vue'),
		meta: {
			index: 0,
			title: '操作人员详情'
		}
	},
	// 参赛用户路由
	{
		path: '/participating_users/table',
		name: 'participating_users_table',
		component: () => import('../views/participating_users/table.vue'),
		meta: {
			index: 0,
			title: '参赛用户列表'
		}
	},
	{
		path: '/participating_users/view',
		name: 'participating_users_view',
		component: () => import('../views/participating_users/view.vue'),
		meta: {
			index: 0,
			title: '参赛用户详情'
		}
	},
	// 系统公告路由
	{
		path: '/system_announcement/table',
		name: 'system_announcement_table',
		component: () => import('../views/system_announcement/table.vue'),
		meta: {
			index: 0,
			title: '系统公告列表'
		}
	},
	{
		path: '/system_announcement/view',
		name: 'system_announcement_view',
		component: () => import('../views/system_announcement/view.vue'),
		meta: {
			index: 0,
			title: '系统公告详情'
		}
	},
	// 项目类别路由
	{
		path: '/project_category/table',
		name: 'project_category_table',
		component: () => import('../views/project_category/table.vue'),
		meta: {
			index: 0,
			title: '项目类别列表'
		}
	},
	{
		path: '/project_category/view',
		name: 'project_category_view',
		component: () => import('../views/project_category/view.vue'),
		meta: {
			index: 0,
			title: '项目类别详情'
		}
	},
	// 比赛项目路由
	{
		path: '/event/table',
		name: 'event_table',
		component: () => import('../views/event/table.vue'),
		meta: {
			index: 0,
			title: '比赛项目列表'
		}
	},
	{
		path: '/event/view',
		name: 'event_view',
		component: () => import('../views/event/view.vue'),
		meta: {
			index: 0,
			title: '比赛项目详情'
		}
	},
	// 项目选手路由
	{
		path: '/event_players/table',
		name: 'event_players_table',
		component: () => import('../views/event_players/table.vue'),
		meta: {
			index: 0,
			title: '项目选手列表'
		}
	},
	{
		path: '/event_players/view',
		name: 'event_players_view',
		component: () => import('../views/event_players/view.vue'),
		meta: {
			index: 0,
			title: '项目选手详情'
		}
	},
	// 项目赛程路由
	{
		path: '/project_schedule/table',
		name: 'project_schedule_table',
		component: () => import('../views/project_schedule/table.vue'),
		meta: {
			index: 0,
			title: '项目赛程列表'
		}
	},
	{
		path: '/project_schedule/view',
		name: 'project_schedule_view',
		component: () => import('../views/project_schedule/view.vue'),
		meta: {
			index: 0,
			title: '项目赛程详情'
		}
	},
	// 成绩信息路由
	{
		path: '/achievement_information/table',
		name: 'achievement_information_table',
		component: () => import('../views/achievement_information/table.vue'),
		meta: {
			index: 0,
			title: '成绩信息列表'
		}
	},
	{
		path: '/achievement_information/view',
		name: 'achievement_information_view',
		component: () => import('../views/achievement_information/view.vue'),
		meta: {
			index: 0,
			title: '成绩信息详情'
		}
	},
	// 成绩排行路由
	{
		path: '/grade_ranking/table',
		name: 'grade_ranking_table',
		component: () => import('../views/grade_ranking/table.vue'),
		meta: {
			index: 0,
			title: '成绩排行列表'
		}
	},
	{
		path: '/grade_ranking/view',
		name: 'grade_ranking_view',
		component: () => import('../views/grade_ranking/view.vue'),
		meta: {
			index: 0,
			title: '成绩排行详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "校运会赛事管理系统-admin";
	document.title = title;
})

export default router

<template>
	<header>
		<div class="warp">
			<el-row style="width: 100%;">
				<el-col :span="2" class="action_left">
					<a class="btn_menu" href="javascript:void(0)" @click="$emit('change', !isCollapse)">
						<i :class="{ 'el-icon-menu': !isCollapse, 'el-icon-s-grid': isCollapse }" ></i>
					</a>
				</el-col>
				<el-col :span="18" class="action_center">
					欢迎使用校园赛事管理系统
				</el-col>
				<el-col :span="4" class="action_right">
					<el-dropdown @command="handleCommand">
						<div class="el-dropdown-link" style="margin-right: 2rem;">
							<el-avatar style="margin-top: 0.25rem; width: 2.3rem; overflow: hidden;"
								:src="$fullUrl(user.avatar)">
								<img style="width: 2.3rem; overflow: hidden" src="/img/error.png" />
							</el-avatar>
							<span style="margin-left: 0.5rem; position: relative;top: -0.75rem;">{{ user.nickname ||
								user.username }}</span>
						</div>
						<el-dropdown-menu slot="dropdown">
							<el-dropdown-item command="/user/info">个人信息</el-dropdown-item>
							<el-dropdown-item command="/user/password">修改密码</el-dropdown-item>
							<el-dropdown-item command="/quit" divided>退出</el-dropdown-item>
						</el-dropdown-menu>
					</el-dropdown>
				</el-col>
			</el-row>
		</div>
	</header>
</template>


<script>
export default {
	model: {
		event: 'change',
		prop: 'isCollapse'
	},
	props: {
		isCollapse: {
			trye: Boolean,
			default: true
		}
	},
	data() {
		return {
			activeIndex: '1',
			activeIndex2: '1',
			user: this.$store.state.user,
			search: ""
		};
	},
	methods: {
		handleSelect(key, keyPath) {
			console.log(key, keyPath);
		},
		handleCommand(command) {
			if (command === "/quit") {
				this.$get("~/api/user/quit", {}, (res) => {
					this.$store.commit("quit");
					this.$router.push("/login");
				});
			} else if (command.indexOf("http") !== -1) {
				let token = $.db.get("token");
				if (token) {
					location.href = command + "?token=" + token;
				}
			} else {
				this.$router.push(command);
			}
		}
	}
}
</script>

<style scoped="scoped">
.warp {
	display: flex;
	justify-content: space-between;
	/* 分布元素，使action_right靠右 */
	align-items: center;
	/* 垂直居中对齐 */
	width: 100%;
}

header {
	border-bottom: var(--color_border);
	color: #fff;

	/* 背景颜色 */
	background-color: #51a6ff !important;
	/* border: 1px dashed #ff9a00; */
	height: 100px !important;
}





.action_center {
	float: left;
	/* line-height: 51px; */
	/* text-align: center; */
	/* flex-grow: 1; */
	/* 让action_center扩展以占据可用空间 */
}

.action_right {
	/* text-align: right; */
	float: right;
	/* width: 30%; */
	/* text-align: left; */
	/* padding-left: 30px; */
	height: 100px;
	margin-left: -1600px;
	line-height: 100px;
}

.el-dropdown {
	color: #fff;
}

.btn_menu {
	display: inline-block;
	padding: 0.625rem;
}



/*  顶部栏内 左边图标样式 */

.action_left .el-icon-menu {
	color: #020a16;
	/* display: none; */
}

#app header .action_center {
	color: #fff;
	font-size: 26px;
	/* margin-left: 450px; */
	line-height: 100px;
}

/*  顶部栏内 左边图标样式  点击后样式*/
.action_left .el-icon-s-grid {
	color: #ff9a00;
}

.action_right .el-dropdown .el-avatar {
	/* 圆角边框 */
	border-radius: 20px !important;
}

.action_right .el-dropdown span:nth-child(2) {
	font-size: 24px !important;
	color: #fff;
}
</style>

<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','entry_name') || $check_field('add','entry_name') || $check_field('set','entry_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目名称" prop="entry_name">
												<el-input id="entry_name" v-model="form['entry_name']" placeholder="请输入项目名称"
							  v-if="user_group === '管理员' || (form['project_schedule_id'] && $check_field('set','entry_name')) || (!form['project_schedule_id'] && $check_field('add','entry_name'))" :disabled="disabledObj['entry_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','entry_name')">{{form['entry_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_category') || $check_field('add','project_category') || $check_field('set','project_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目类别" prop="project_category">
												<el-input id="project_category" v-model="form['project_category']" placeholder="请输入项目类别"
							  v-if="user_group === '管理员' || (form['project_schedule_id'] && $check_field('set','project_category')) || (!form['project_schedule_id'] && $check_field('add','project_category'))" :disabled="disabledObj['project_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_category')">{{form['project_category']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_location') || $check_field('add','project_location') || $check_field('set','project_location')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目地点" prop="project_location">
												<el-input id="project_location" v-model="form['project_location']" placeholder="请输入项目地点"
							  v-if="user_group === '管理员' || (form['project_schedule_id'] && $check_field('set','project_location')) || (!form['project_schedule_id'] && $check_field('add','project_location'))" :disabled="disabledObj['project_location_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_location')">{{form['project_location']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','game_time') || $check_field('add','game_time') || $check_field('set','game_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛时间" prop="game_time">
												<el-input id="game_time" v-model="form['game_time']" placeholder="请输入比赛时间"
							  v-if="user_group === '管理员' || (form['project_schedule_id'] && $check_field('set','game_time')) || (!form['project_schedule_id'] && $check_field('add','game_time'))" :disabled="disabledObj['game_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','game_time')">{{form['game_time']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','matters_needing_attention') || $check_field('add','matters_needing_attention') || $check_field('set','matters_needing_attention')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="注意事项" prop="matters_needing_attention">
								<el-input type="textarea" id="matters_needing_attention" v-model="form['matters_needing_attention']" placeholder="请输入注意事项"
						v-if="user_group === '管理员' || (form['project_schedule_id'] && $check_field('set','matters_needing_attention')) || (!form['project_schedule_id'] && $check_field('add','matters_needing_attention'))" :disabled="disabledObj['matters_needing_attention_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','matters_needing_attention')">{{form['matters_needing_attention']}}</div>
							</el-form-item>
			</el-col>
						
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "project_schedule_id",
				url_add: "~/api/project_schedule/add?",
				url_set: "~/api/project_schedule/set?",
				url_get_obj: "~/api/project_schedule/get_obj?",
				url_upload: "~/api/project_schedule/upload?",

				query: {
					"project_schedule_id": 0,
				},

				form: {
								"entry_name":  '', // 项目名称
										"project_category":  '', // 项目类别
										"project_location":  '', // 项目地点
										"game_time":  '', // 比赛时间
										"matters_needing_attention":  '', // 注意事项
												"project_schedule_id": 0, // ID
						
				},
				disabledObj:{
								"entry_name_isDisabled": false,
										"project_category_isDisabled": false,
										"project_location_isDisabled": false,
										"game_time_isDisabled": false,
										"matters_needing_attention_isDisabled": false,
										},

	
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
														// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
																
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
														$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


															

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																					return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/project_schedule/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/project_schedule/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/project_schedule/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/project_schedule/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/project_schedule/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
												},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>

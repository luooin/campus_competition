<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','announcement_title') || $check_field('add','announcement_title') || $check_field('set','announcement_title')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="公告标题" prop="announcement_title">
												<el-input id="announcement_title" v-model="form['announcement_title']" placeholder="请输入公告标题"
							  v-if="user_group === '管理员' || (form['system_announcement_id'] && $check_field('set','announcement_title')) || (!form['system_announcement_id'] && $check_field('add','announcement_title'))" :disabled="disabledObj['announcement_title_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','announcement_title')">{{form['announcement_title']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','announcement_label') || $check_field('add','announcement_label') || $check_field('set','announcement_label')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="公告标签" prop="announcement_label">
												<el-input id="announcement_label" v-model="form['announcement_label']" placeholder="请输入公告标签"
							  v-if="user_group === '管理员' || (form['system_announcement_id'] && $check_field('set','announcement_label')) || (!form['system_announcement_id'] && $check_field('add','announcement_label'))" :disabled="disabledObj['announcement_label_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','announcement_label')">{{form['announcement_label']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','date_of_announcement') || $check_field('add','date_of_announcement') || $check_field('set','date_of_announcement')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="公告日期" prop="date_of_announcement">
								<el-date-picker :disabled="disabledObj['date_of_announcement_isDisabled']" v-if="user_group === '管理员' || (form['system_announcement_id'] && $check_field('set','date_of_announcement')) || (!form['system_announcement_id'] && $check_field('add','date_of_announcement'))" id="date_of_announcement"
						v-model="form['date_of_announcement']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','date_of_announcement')">{{form['date_of_announcement']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','announcement_description') || $check_field('add','announcement_description') || $check_field('set','announcement_description')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="公告描述" prop="announcement_description">
								<el-input type="textarea" id="announcement_description" v-model="form['announcement_description']" placeholder="请输入公告描述"
						v-if="user_group === '管理员' || (form['system_announcement_id'] && $check_field('set','announcement_description')) || (!form['system_announcement_id'] && $check_field('add','announcement_description'))" :disabled="disabledObj['announcement_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','announcement_description')">{{form['announcement_description']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','announcement_content') || $check_field('add','announcement_content') || $check_field('set','announcement_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="公告内容" prop="announcement_content">
								<el-input type="textarea" id="announcement_content" v-model="form['announcement_content']" placeholder="请输入公告内容"
						v-if="user_group === '管理员' || (form['system_announcement_id'] && $check_field('set','announcement_content')) || (!form['system_announcement_id'] && $check_field('add','announcement_content'))" :disabled="disabledObj['announcement_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','announcement_content')">{{form['announcement_content']}}</div>
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
				field: "system_announcement_id",
				url_add: "~/api/system_announcement/add?",
				url_set: "~/api/system_announcement/set?",
				url_get_obj: "~/api/system_announcement/get_obj?",
				url_upload: "~/api/system_announcement/upload?",

				query: {
					"system_announcement_id": 0,
				},

				form: {
								"announcement_title":  '', // 公告标题
										"announcement_label":  '', // 公告标签
										"date_of_announcement":  '', // 公告日期
										"announcement_description":  '', // 公告描述
										"announcement_content":  '', // 公告内容
												"system_announcement_id": 0, // ID
						
				},
				disabledObj:{
								"announcement_title_isDisabled": false,
										"announcement_label_isDisabled": false,
										"date_of_announcement_isDisabled": false,
										"announcement_description_isDisabled": false,
										"announcement_content_isDisabled": false,
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
						        if (this.form["date_of_announcement"].indexOf("-")===-1){
          this.form["date_of_announcement"] = this.$toTime(parseInt(this.form["date_of_announcement"]),"yyyy-MM-dd")
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


								        if(this.form["date_of_announcement"]=="0000-00-00"){
          this.form["date_of_announcement"] = null;
        }
				if(parseInt(this.form["date_of_announcement"]) > 9999){
					this.form["date_of_announcement"] = this.$toTime(parseInt(this.form["date_of_announcement"]),"yyyy-MM-dd")
				}
								

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
					bl = this.$check_action('/system_announcement/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/system_announcement/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/system_announcement/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/system_announcement/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/system_announcement/view','get');
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

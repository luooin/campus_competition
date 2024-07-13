<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','entry_name') || $check_field('add','entry_name') || $check_field('set','entry_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目名称" prop="entry_name">
												<el-input id="entry_name" v-model="form['entry_name']" placeholder="请输入项目名称"
							  v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','entry_name')) || (!form['grade_ranking_id'] && $check_field('add','entry_name'))" :disabled="disabledObj['entry_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','entry_name')">{{form['entry_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_category') || $check_field('add','project_category') || $check_field('set','project_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目类别" prop="project_category">
												<el-input id="project_category" v-model="form['project_category']" placeholder="请输入项目类别"
							  v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','project_category')) || (!form['grade_ranking_id'] && $check_field('add','project_category'))" :disabled="disabledObj['project_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_category')">{{form['project_category']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_time') || $check_field('add','project_time') || $check_field('set','project_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目时间" prop="project_time">
												<el-input id="project_time" v-model="form['project_time']" placeholder="请输入项目时间"
							  v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','project_time')) || (!form['grade_ranking_id'] && $check_field('add','project_time'))" :disabled="disabledObj['project_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_time')">{{form['project_time']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','event_players') || $check_field('add','event_players') || $check_field('set','event_players')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目选手" prop="event_players">
													<el-select v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','event_players')) || (!form['grade_ranking_id'] && $check_field('add','event_players'))" id="event_players" v-model="form['event_players']" :disabled="disabledObj['event_players_isDisabled']">
							<el-option v-for="o in list_user_event_players" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','event_players')" id="event_players" v-model="form['event_players']" :disabled="true">
							<el-option v-for="o in list_user_event_players" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_student_id') || $check_field('add','user_student_id') || $check_field('set','user_student_id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户学号" prop="user_student_id">
												<el-input id="user_student_id" v-model="form['user_student_id']" placeholder="请输入用户学号"
							  v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','user_student_id')) || (!form['grade_ranking_id'] && $check_field('add','user_student_id'))" :disabled="disabledObj['user_student_id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_student_id')">{{form['user_student_id']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','user_name')) || (!form['grade_ranking_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','score') || $check_field('add','score') || $check_field('set','score')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="成绩分数" prop="score">
								<el-input-number id="score" v-model.number="form['score']"
						v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','score')) || (!form['grade_ranking_id'] && $check_field('add','score'))" :disabled="disabledObj['score_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','score')">{{form['score']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_rankings') || $check_field('add','number_of_rankings') || $check_field('set','number_of_rankings')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="排行名数" prop="number_of_rankings">
								<el-input-number id="number_of_rankings" v-model.number="form['number_of_rankings']"
						v-if="user_group === '管理员' || (form['grade_ranking_id'] && $check_field('set','number_of_rankings')) || (!form['grade_ranking_id'] && $check_field('add','number_of_rankings'))" :disabled="disabledObj['number_of_rankings_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_rankings')">{{form['number_of_rankings']}}</div>
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
				field: "grade_ranking_id",
				url_add: "~/api/grade_ranking/add?",
				url_set: "~/api/grade_ranking/set?",
				url_get_obj: "~/api/grade_ranking/get_obj?",
				url_upload: "~/api/grade_ranking/upload?",

				query: {
					"grade_ranking_id": 0,
				},

				form: {
								"entry_name":  '', // 项目名称
										"project_category":  '', // 项目类别
										"project_time":  '', // 项目时间
										"event_players": 0, // 项目选手
										"user_student_id":  '', // 用户学号
										"user_name":  '', // 用户姓名
										"score":  0, // 成绩分数
										"number_of_rankings":  0, // 排行名数
												"grade_ranking_id": 0, // ID
						
				},
				disabledObj:{
								"entry_name_isDisabled": false,
										"project_category_isDisabled": false,
										"project_time_isDisabled": false,
										"event_players_isDisabled": false,
										"user_student_id_isDisabled": false,
										"user_name_isDisabled": false,
					          			"score_isDisabled": false,
					          			"number_of_rankings_isDisabled": false,
										},

	
		
		
		
					// 用户列表
				list_user_event_players: [],
				
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
				/**
			 * 获取参赛用户用户列表
			 */
			async get_list_user_event_players() {
                // if(this.user_group !== "管理员" && this.form["event_players"] === 0) {
                //     this.form["event_players"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=参赛用户");
                if(json.result && json.result.list){
                    this.list_user_event_players = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_event_players(id){
				var obj = this.list_user_event_players.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
		
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
					bl = this.$check_action('/grade_ranking/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/grade_ranking/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/grade_ranking/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/grade_ranking/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/grade_ranking/view','get');
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
											this.get_list_user_event_players();
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

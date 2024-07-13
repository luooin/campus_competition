<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','entry_name') || $check_field('add','entry_name') || $check_field('set','entry_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目名称" prop="entry_name">
												<el-input id="entry_name" v-model="form['entry_name']" placeholder="请输入项目名称"
							  v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','entry_name')) || (!form['event_players_id'] && $check_field('add','entry_name'))" :disabled="disabledObj['entry_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','entry_name')">{{form['entry_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_category') || $check_field('add','project_category') || $check_field('set','project_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目类别" prop="project_category">
												<el-input id="project_category" v-model="form['project_category']" placeholder="请输入项目类别"
							  v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','project_category')) || (!form['event_players_id'] && $check_field('add','project_category'))" :disabled="disabledObj['project_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_category')">{{form['project_category']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_time') || $check_field('add','project_time') || $check_field('set','project_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目时间" prop="project_time">
												<el-input id="project_time" v-model="form['project_time']" placeholder="请输入项目时间"
							  v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','project_time')) || (!form['event_players_id'] && $check_field('add','project_time'))" :disabled="disabledObj['project_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_time')">{{form['project_time']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_location') || $check_field('add','project_location') || $check_field('set','project_location')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目地点" prop="project_location">
												<el-input id="project_location" v-model="form['project_location']" placeholder="请输入项目地点"
							  v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','project_location')) || (!form['event_players_id'] && $check_field('add','project_location'))" :disabled="disabledObj['project_location_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_location')">{{form['project_location']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','event_players') || $check_field('add','event_players') || $check_field('set','event_players')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目选手" prop="event_players">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_event_players(form['event_players']) }}
							<!--<el-input id="business_name" v-model="form['event_players']" placeholder="请输入项目选手"-->
							<!--v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','event_players')) || (!form['event_players_id'] && $check_field('add','event_players'))" :disabled="disabledObj['event_players_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','event_players')">{{form['event_players']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','event_players')) || (!form['event_players_id'] && $check_field('add','event_players'))" id="event_players" v-model="form['event_players']" :disabled="disabledObj['event_players_isDisabled']">
								<el-option v-for="o in list_user_event_players" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','event_players')" id="event_players" v-model="form['event_players']" :disabled="true">
								<el-option v-for="o in list_user_event_players" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="event_players" v-model="form['event_players']" :disabled="disabledObj['event_players_isDisabled']">
							<el-option v-for="o in list_user_event_players" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_student_id') || $check_field('add','user_student_id') || $check_field('set','user_student_id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户学号" prop="user_student_id">
												<el-input id="user_student_id" v-model="form['user_student_id']" placeholder="请输入用户学号"
							  v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','user_student_id')) || (!form['event_players_id'] && $check_field('add','user_student_id'))" :disabled="disabledObj['user_student_id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_student_id')">{{form['user_student_id']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','user_name')) || (!form['event_players_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_group') || $check_field('add','project_group') || $check_field('set','project_group')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目组别" prop="project_group">
												<el-input id="project_group" v-model="form['project_group']" placeholder="请输入项目组别"
							  v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','project_group')) || (!form['event_players_id'] && $check_field('add','project_group'))" :disabled="disabledObj['project_group_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_group')">{{form['project_group']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','match_date') || $check_field('add','match_date') || $check_field('set','match_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛日期" prop="match_date">
								<el-date-picker :disabled="disabledObj['match_date_isDisabled']" v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','match_date')) || (!form['event_players_id'] && $check_field('add','match_date'))" id="match_date"
						v-model="form['match_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','match_date')">{{form['match_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="备注信息" prop="remarks">
								<el-input type="textarea" id="remarks" v-model="form['remarks']" placeholder="请输入备注信息"
						v-if="user_group === '管理员' || (form['event_players_id'] && $check_field('set','remarks')) || (!form['event_players_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','remarks')">{{form['remarks']}}</div>
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
				field: "event_players_id",
				url_add: "~/api/event_players/add?",
				url_set: "~/api/event_players/set?",
				url_get_obj: "~/api/event_players/get_obj?",
				url_upload: "~/api/event_players/upload?",

				query: {
					"event_players_id": 0,
				},

				form: {
								"entry_name":  '', // 项目名称
										"project_category":  '', // 项目类别
										"project_time":  '', // 项目时间
										"project_location":  '', // 项目地点
										"event_players": 0, // 项目选手
										"user_student_id":  '', // 用户学号
										"user_name":  '', // 用户姓名
										"project_group":  '', // 项目组别
										"match_date":  '', // 比赛日期
										"remarks":  '', // 备注信息
												"event_players_id": 0, // ID
						
				},
				disabledObj:{
								"entry_name_isDisabled": false,
										"project_category_isDisabled": false,
										"project_time_isDisabled": false,
										"project_location_isDisabled": false,
										"event_players_isDisabled": false,
										"user_student_id_isDisabled": false,
										"user_name_isDisabled": false,
										"project_group_isDisabled": false,
										"match_date_isDisabled": false,
										"remarks_isDisabled": false,
										},

	
		
		
		
		
					// 用户列表
				list_user_event_players: [],
						// 用户组
				group_user_event_players: "",
				
		
		
		
		
	
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
					/**
			 * 获取参赛用户用户组
			 */
			async get_group_user_event_players() {
							this.form["event_players"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=参赛用户");
				if(json.result && json.result.obj){
					this.group_user_event_players = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_event_players(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_event_players.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["event_players"] = id
									_this.disabledObj['event_players' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "event_players") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
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
																		        if (this.form["match_date"].indexOf("-")===-1){
          this.form["match_date"] = this.$toTime(parseInt(this.form["match_date"]),"yyyy-MM-dd")
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


																										        if(this.form["match_date"]=="0000-00-00"){
          this.form["match_date"] = null;
        }
				if(parseInt(this.form["match_date"]) > 9999){
					this.form["match_date"] = this.$toTime(parseInt(this.form["match_date"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/event_players/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/event_players/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/event_players/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/event_players/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/event_players/view','get');
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
					this.get_group_user_event_players();
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

<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

			<el-col
				v-if="user_group === '管理员' || $check_field('get', 'entry_name') || $check_field('add', 'entry_name') || $check_field('set', 'entry_name')"
				:xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目名称" prop="entry_name">
					<el-input id="entry_name" v-model="form['entry_name']" placeholder="请输入项目名称"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set', 'entry_name')) || (!form['event_id'] && $check_field('add', 'entry_name'))"
						:disabled="disabledObj['entry_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get', 'entry_name')">{{ form['entry_name'] }}</div>
				</el-form-item>
			</el-col>
			<el-col
				v-if="user_group === '管理员' || $check_field('get', 'project_category') || $check_field('add', 'project_category') || $check_field('set', 'project_category')"
				:xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目类别" prop="project_category">
					<el-select id="project_category" v-model="form['project_category']"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set', 'project_category')) || (!form['event_id'] && $check_field('add', 'project_category'))">
						<el-option v-for="o in list_project_category" :key="o['project_category']"
							:label="o['project_category']" :value="o['project_category']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get', 'project_category')">{{ form['project_category'] }}</div>
				</el-form-item>
			</el-col>
			<el-col
				v-if="user_group === '管理员' || $check_field('get', 'project_time') || $check_field('add', 'project_time') || $check_field('set', 'project_time')"
				:xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目时间" prop="project_time">
					<el-input id="project_time" v-model="form['project_time']" placeholder="请输入项目时间"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set', 'project_time')) || (!form['event_id'] && $check_field('add', 'project_time'))"
						:disabled="disabledObj['project_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get', 'project_time')">{{ form['project_time'] }}</div>
				</el-form-item>
			</el-col>
			<el-col
				v-if="user_group === '管理员' || $check_field('get', 'project_location') || $check_field('add', 'project_location') || $check_field('set', 'project_location')"
				:xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目地点" prop="project_location">
					<el-input id="project_location" v-model="form['project_location']" placeholder="请输入项目地点"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set', 'project_location')) || (!form['event_id'] && $check_field('add', 'project_location'))"
						:disabled="disabledObj['project_location_isDisabled']"></el-input>
					<div v-else-if="$check_field('get', 'project_location')">{{ form['project_location'] }}</div>
				</el-form-item>
			</el-col>
			<el-col
				v-if="user_group === '管理员' || $check_field('get', 'project_description') || $check_field('add', 'project_description') || $check_field('set', 'project_description')"
				:xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目描述" prop="project_description">
					<el-input id="project_description" v-model="form['project_description']" placeholder="请输入项目描述"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set', 'project_description')) || (!form['event_id'] && $check_field('add', 'project_description'))"
						:disabled="disabledObj['project_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get', 'project_description')">{{ form['project_description'] }}</div>
				</el-form-item>
			</el-col>
			<el-col
				v-if="user_group === '管理员' || $check_field('get', 'project_picture') || $check_field('add', 'project_picture') || $check_field('set', 'project_picture')"
				:xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目图片" prop="project_picture">
					<el-upload :disabled="disabledObj['project_picture_isDisabled']" id="project_picture"
						class="avatar-uploader" drag accept="image/gif, image/jpeg, image/png, image/jpg" action=""
						:http-request="upload_project_picture" :show-file-list="false"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set', 'project_picture')) || (!form['event_id'] && $check_field('add', 'project_picture'))">
						<img v-if="form['project_picture']" :src="$fullUrl(form['project_picture'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get', 'project_picture')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['project_picture'])"
						:preview-src-list="[$fullUrl(form['project_picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col
				v-if="user_group === '管理员' || $check_field('get', 'project_introduction') || $check_field('add', 'project_introduction') || $check_field('set', 'project_introduction')"
				:xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="项目简介" prop="project_introduction">
					<quill-editor v-model.number="form['project_introduction']"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set', 'project_introduction')) || (!form['event_id'] && $check_field('add', 'project_introduction'))">
					</quill-editor>
					<div v-else-if="$check_field('get', 'project_introduction')" v-html="form['project_introduction']">
					</div>
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
			field: "event_id",
			url_add: "~/api/event/add?",
			url_set: "~/api/event/set?",
			url_get_obj: "~/api/event/get_obj?",
			url_upload: "~/api/event/upload?",

			query: {
				"event_id": 0,
			},

			form: {
				"entry_name": '', // 项目名称
				"project_category": '', // 项目类别
				"project_time": '', // 项目时间
				"project_location": '', // 项目地点
				"project_description": '', // 项目描述
				"project_picture": '', // 项目图片
				"project_introduction": '', // 项目简介
				"event_id": 0, // ID

			},
			disabledObj: {
				"entry_name_isDisabled": false,
				"project_category_isDisabled": false,
				"project_time_isDisabled": false,
				"project_location_isDisabled": false,
				"project_description_isDisabled": false,
				"project_picture_isDisabled": false,
				"project_introduction_isDisabled": false,
			},


			// 项目类别选项列表
			list_project_category: [""],







		}
	},
	methods: {





		/**
	 * 获取项目类别列表
	 */
		async get_list_project_category() {
			var json = await this.$get("~/api/project_category/get_list?");
			if (json.result && json.result.list) {
				this.list_project_category = json.result.list;
			}
			else if (json.error) {
				console.error(json.error);
			}
		},







		/**
* 上传项目图片
* @param {Object} param 图片参数
*/
		upload_project_picture(param) {
			this.uploadFile(param.file, "project_picture");
		},





		/**
		 * 获取对象之前
		 * @param {Object} param
		 */
		get_obj_before(param) {
			var form = "";

			if (this.form && form) {
				Object.keys(this.form).forEach(key => {
					Object.keys(form).forEach(dbKey => {
						// if(dbKey === "charging_standard"){
						// 	this.form['charging_rules'] = form[dbKey];
						// 	this.disabledObj['charging_rules_isDisabled'] = true;
						// };
						if (key === dbKey) {
							this.disabledObj[key + '_isDisabled'] = true;
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
		get_obj_after(json, func) {




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

		is_view() {
			var bl = this.user_group == "管理员";

			if (!bl) {
				bl = this.$check_action('/event/table', 'add');
				console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
			}
			if (!bl) {
				bl = this.$check_action('/event/table', 'set');
				console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
			}
			if (!bl) {
				bl = this.$check_action('/event/view', 'add');
				console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
			}
			if (!bl) {
				bl = this.$check_action('/event/view', 'set');
				console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
			}
			if (!bl) {
				bl = this.$check_action('/event/view', 'get');
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
		this.get_list_project_category();
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

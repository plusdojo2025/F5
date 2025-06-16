package models.dto;
import java.io.Serializable;

	public class Log implements Serializable{
		private int log_id; 			/*ログid*/
		private String log_info; 		/*ログの情報*/
		private int user_id; 			/*ユーザーid*/
		private String created_at; 		/*登録日*/
		
		public int getLog_id() {
			return log_id;
		}
		public void setLog_id(int log_id) {
			this.log_id = log_id;
		}
		public String getLog_info() {
			return log_info;
		}
		public void setLog_info(String log_info) {
			this.log_info = log_info;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		
		public Log(int log_id, String log_info, int user_id, String created_at) {
			super();
			this.log_id = log_id;
			this.log_info = log_info;
			this.user_id = user_id;
			this.created_at = created_at;
		}
		
		public Log() {
			super();
			this.log_id = 0;
			this.log_info = "";
			this.user_id = 0;
			this.created_at = "";
		}
		
	}

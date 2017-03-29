--CREATE Tables
CREATE TABLE public.lp_aircraft(lpac_ac_reg_cd VARCHAR(10), lpac_assmbl_cd VARCHAR(8) NOT NULL, lpac_authority_cd VARCHAR(8) NOT NULL, lpac_operator_cd VARCHAR(3) NOT NULL, PRIMARY KEY (lpac_ac_reg_cd));
CREATE TABLE public.lp_work_package(lpwp_barcode VARCHAR(80), lpwp_name VARCHAR(500) NOT NULL, lpwp_status VARCHAR(12) NOT NULL, lpwp_location VARCHAR(2000), lpwp_date_time_start DATE, lpwp_date_time_end DATE, PRIMARY KEY(lpwp_barcode));
CREATE TABLE public.lp_task(lptk_code SERIAL, lptk_barcode VARCHAR(80) NOT NULL, lptk_code_mxi numeric(10) NOT NULL, lpac_ac_reg_cd VARCHAR(10) NOT NULL, lpwp_barcode VARCHAR(80) NOT NULL, lptk_name VARCHAR(500) NOT NULL, lptk_status VARCHAR(12) NOT NULL, lptk_task_type VARCHAR(16) NOT NULL, lptk_due_date DATE NOT NULL, lptk_due_date_ext DATE, lptk_due_date_fnl DATE NOT NULL, lptk_yield FLOAT8, lptk_duration FLOAT8 NOT NULL, lptk_barcode_dvr VARCHAR(80), lptk_due_date_dvr DATE, lptk_priority numeric(2), lptk_sched_status VARCHAR(30), PRIMARY KEY(lptk_code));
CREATE TABLE public.lp_labour(lplb_code SERIAL, lptk_code numeric NOT NULL, lplb_skill VARCHAR(12) NOT NULL, lplb_man_required numeric(10) NOT NULL, lplb_man_hr numeric(6, 2) NOT NULL, PRIMARY KEY(lplb_code));
CREATE TABLE public.lp_part(lppt_code SERIAL, lptk_code numeric NOT NULL, lppt_code_mxi numeric(10) NOT NULL, lppt_code_mxi_group numeric(10) NOT NULL, lppt_name VARCHAR(80) NOT NULL, lppt_status VARCHAR(12) NOT NULL, lppt_quantity FLOAT8 NOT NULL, lppt_date_eta DATE, PRIMARY KEY(lppt_code));
CREATE TABLE public.lp_tool(lptl_code SERIAL, lptk_code numeric NOT NULL, ptl_code_mxi numeric(10) NOT NULL, lptl_name VARCHAR(80) NOT NULL, lptl_quantity FLOAT8 NOT NULL, PRIMARY KEY(lptl_code));
CREATE TABLE public.lp_filter_type(lpft_code SERIAL, lpft_type numeric(2) NOT NULL, PRIMARY KEY(lpft_code));
CREATE TABLE public.lp_current_filter(lpcf_code SERIAL, lpft_code numeric(30) NOT NULL, lpus_code VARCHAR(200) NOT NULL, lpcf_update_dt DATE NOT NULL, lpcf_data TEXT NOT NULL, PRIMARY KEY(lpcf_code));
--CREATE Index
CREATE INDEX indx_fk_lptk_lpac_ac_reg_cd ON lp_task(lpac_ac_reg_cd);
CREATE INDEX indx_fk_lptk_lpwp_barcode ON lp_task(lpwp_barcode);
CREATE UNIQUE INDEX indx_lptk_barcode ON lp_task(lptk_barcode);
CREATE UNIQUE INDEX indx_lptk_code_mxi ON lp_task(lptk_code_mxi);
CREATE INDEX indx_lptk_due_date_dvr ON lp_task(lptk_due_date_dvr);
CREATE INDEX indx_lptk_due_date_fnl ON lp_task(lptk_due_date_fnl);
CREATE INDEX indx_fk_lplb_lptk_code ON lp_labour(lptk_code);
CREATE INDEX indx_lplb_skill ON lp_labour(lplb_skill);
CREATE INDEX indx_fk_lppt_lptk_code ON lp_part(lptk_code);
CREATE INDEX indx_lppt_date_eta ON lp_part(lppt_date_eta);
CREATE INDEX indx_fk_lptl_lptk_code ON lp_tool(lptk_code);
CREATE UNIQUE INDEX indx_fk_lpft_code_lpus_code ON lp_current_filter(lpft_code, lpus_code);
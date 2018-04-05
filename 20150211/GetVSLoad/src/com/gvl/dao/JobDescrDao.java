package com.gvl.dao;

import org.hibernate.Session;

import com.gvl.entities.IJobDescr;
import com.gvl.entities.JobDescr;

public class JobDescrDao {
	public IJobDescr getJobDescr(Session session, final int jobId) {
		IJobDescr jobDescr = null;

		jobDescr = (IJobDescr) session.load(JobDescr.class, jobId);
		return jobDescr;
	}
}

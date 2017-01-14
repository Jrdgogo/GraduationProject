package com.mmt.tourism.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ParamFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//放行（代理request对象）
		chain.doFilter(new paramRequest((HttpServletRequest) request), response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	class paramRequest extends HttpServletRequestWrapper {
		

		public paramRequest(HttpServletRequest request) {
			super(request);
		}

		//覆盖（去除重复参数+非空+非空串）
		public String[] getParameterValues(String name) {
			String[] params = super.getParameterValues(name);
			if (params == null)
				return params;

			params = removeNULLAndALikeParam(params);
			
			return params;
		}

		private String[] removeNULLAndALikeParam(String[] params) {
			Set<String> paramSet = new HashSet<String>();
			for (String s : params) {
				if (s == null||"".equals(s) || "undefined".equals(s))
					continue;
				paramSet.add(s);
			}
			return paramSet.toArray(new String[paramSet.size()]);
		}

	}
}

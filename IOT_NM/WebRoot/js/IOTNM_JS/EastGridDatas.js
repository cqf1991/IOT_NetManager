			function updateGridData(str) {//str为传入的单个网络/子网/节点
				
					var gridHandle = Ext.getCmp('Rigthgrid');
					if (str.NTID!=null) {//网络信息显示
							var myGrid = Ext.getCmp("buttomGrid");
							var store = Ext.getCmp("buttomGrid").getStore();
								myTitle = "网络名称：" + str.NTID+"号网络";
								myGrid.setTitle(myTitle);
								if(str.subnet!=null)         //存在子网则显示子网
								{
								for(var i in str.subnet)
								ShowSubNets(str);//
								}
							gridHandle.setTitle("网络信息");
							gridHandle.setSource({
								"网络ID" : str.NTID+"号网络",			
								"网络描述" : str.NTDSCRPT,			
								"经纬度" : str.CVRG_LB_X + ","
										+ str.CVRG_LB_Y,								
								"注册日期" : Nets.netList[i].netDate,
								"子网个数" : str.SUBNETSIZE,
							});
							break;
						}

						for (j = 0; j < Nets.netList[i].subnets.length; j++) {
							//alert(Nets.netList[i].subnets[j].subnetName);

							if (str == Nets.netList[i].subnets[j].subnetName) {
								SubNetIndex_ = j;
								CurrentSubNet = Nets.netList[i].subnets[j].subnetID;
								ShowNodes(i, j);
								gridHandle.setTitle("子网信息");
								gridHandle
										.setSource({
											"子网ID" : Nets.netList[i].subnets[j].subnetID,
											"子网名称" : Nets.netList[i].subnets[j].subnetName,
											"子网地址" : Nets.netList[i].subnets[j].subnetAddr,
											"子网描述" : Nets.netList[i].subnets[j].subnetDscrb,
											"经纬度" : Nets.netList[i].subnets[j].subnetLng
													+ ","
													+ Nets.netList[i].subnets[j].subnetLat,
											"接入方式" : Nets.netList[i].subnets[j].subnetAcc,
											"工作周期" : Nets.netList[i].subnets[j].subnetCir,
											"工作信道" : Nets.netList[i].subnets[j].subnetFrq,
											"节点个数" : Nets.netList[i].subnets[j].nodeCount
										});
								break;
							}

							for (k = 0; k < Nets.netList[i].subnets[j].nodes.length; k++) {
								if (str == Nets.netList[i].subnets[j].nodes[k].nodeID) {
									var position = new BMap.Point(
											Nets.netList[i].subnets[j].nodes[k].nodeLng,
											Nets.netList[i].subnets[j].nodes[k].nodeLat);
									var opts = {
										width : 100,
										height : 140,
										title : "       节点基本信息",
										enableMessage : false
									}
									var info = new BMap.InfoWindow(
											"节点ID:  "
													+ Nets.netList[i].subnets[j].nodes[k].nodeID
													+ "<br>"
													+ "节点物理地址:  "
													+ Nets.netList[i].subnets[j].nodes[k].nodePhyAddr
													+ "<br>"
													+ "节点发射功率:  "
													+ Nets.netList[i].subnets[j].nodes[k].nodePower
													+ "<br>"
													+ "节点当前电压:  "
													+ Nets.netList[i].subnets[j].nodes[k].nodeVoltage
													+ "<br>"
													+ "节点类型:  "
													+ Nets.netList[i].subnets[j].nodes[k].nodeType
													+ "<br>"
													+ "感知类型:  "
													+ Nets.netList[i].subnets[j].nodes[k].sensorType
													+ "<br>"
													+ "经纬度:"
													+ Nets.netList[i].subnets[j].nodes[k].nodeLng
													+ ","
													+ Nets.netList[i].subnets[j].nodes[k].nodeLat,
											opts);
									Map.openInfoWindow(info, position);
									gridHandle.setTitle("节点信息");
									gridHandle
											.setSource({
												"节点ID" : Nets.netList[i].subnets[j].nodes[k].nodeID,
												"节点类型" : Nets.netList[i].subnets[j].nodes[k].nodeType,
												"感知类型" : Nets.netList[i].subnets[j].nodes[k].sensorType,
												"节点物理地址" : Nets.netList[i].subnets[j].nodes[k].nodePhyAddr,
												"节点发射功率" : Nets.netList[i].subnets[j].nodes[k].nodePower,
												"节点电压" : Nets.netList[i].subnets[j].nodes[k].nodeVoltage,
												"经纬度" : Nets.netList[i].subnets[j].nodes[k].nodeLng
														+ ","
														+ Nets.netList[i].subnets[j].nodes[k].nodeLat

											});
									break;
								}
							}
						}
					}
				

				
			
    
////////////////////////////////////////////////////////////////////////////////
//	
//	Copyright 2014 Ardisia Labs LLC. All Rights Reserved.
//
//	This file is licensed under the Ardisia Component Library License. 
//
//	Only license holders are entitled to use this file subject to the  
//	conditions of the license. All other uses are expressly forbidden. Visit 
//	http://www.ardisialabs.com to view and purchase a license.
//
//	Apache Flex's source code notices are reproduced below.
//
// 	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//
//  Licensed to the Apache Software Foundation (ASF) under one or more
//  contributor license agreements.  See the NOTICE file distributed with
//  this work for additional information regarding copyright ownership.
//  The ASF licenses this file to You under the Apache License, Version 2.0
//  (the "License"); you may not use this file except in compliance with
//  the License.  You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

package  cn.superion.preloaders
{

import flash.display.Bitmap;

import vamos.components.preloaders.BarPreloader;

public class BarPreloader extends vamos.components.preloaders.BarPreloader
{
	
	//--------------------------------------------------------------------------
	//
	//  Embedded Assets
	//
	//--------------------------------------------------------------------------
	
	[Embed(source="//assets/images/superion-log.png")]
	public var LogoAsset:Class;
	
	[Embed(source="//assets/images/superion-preloader.png")]
	public var ArdisiaComponentSetAsset:Class;
	
	//--------------------------------------------------------------------------
	//
	//  Variables
	//
	//--------------------------------------------------------------------------
	
	protected var logo:Bitmap;
	
	protected var componentLogo:Bitmap;
	
	//--------------------------------------------------------------------------
	//
	//  Overridden methods
	//
	//--------------------------------------------------------------------------
	
	//----------------------------------
	//  interface
	//----------------------------------
	
	override public function initialize():void
	{
		super.initialize();
		
		// default to 2 second delay
		delayAfterInitialization = 0;
	}
	
	//----------------------------------
	//  private / protected
	//----------------------------------
	
	override protected function createChildren():void
	{
		if (childrenCreated)
			return;
		
		logo = new LogoAsset();
		addChild(logo);
		
		componentLogo = new ArdisiaComponentSetAsset();
		addChild(componentLogo);
		
		super.createChildren();
		
	}
	
	override protected function updateDisplayList():void
	{
		super.updateDisplayList();
		
		stageWidth = stage.stageWidth;
		stageHeight = stage.stageHeight;
		
		// layout the logo
		if (logo)
		{
			logo.x = stageWidth - logo.width - 65;
			logo.y = stageHeight - logo.height - 50;
		}
		
		// layout the component logo
		if (componentLogo)
		{
			componentLogo.x = barDisplay.x;
			componentLogo.y = barDisplay.y - 26 - 31;
		}
	}
	
}

}
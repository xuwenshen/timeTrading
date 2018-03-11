$(
	function ()
	{
/*		var demandKeyWords = $('#demandKeyWords');
		demandKeyWords.val('如：爬山，郊游，全屋清洁等');
		$.textBoxAddEventListener(demandKeyWords, 'focus', '如：爬山，郊游，全屋清洁等', '', '#434343');
		$.textBoxAddEventListener(demandKeyWords, 'blur', '如：爬山，郊游，全屋清洁等', '如：爬山，郊游，全屋清洁等', '#a0a0a0');*/
		
		var demandStartDateTime  = $('#demandStartDateTime');
		var demandEndDateTime    = $('#demandEndDateTime');
		var buttonDemandSearch   = $('#buttonDemandSearch');
		

		var dateTimePickerConf =
		{
			lang: 'Chinese',
			i18n:
			{
				Chinese:
				{
					months:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
					dayOfWeek:["日","一","二","三","四","五","六"]
				}
			},
			format: 'Y-m-d H:i',
			step: 30
		}
		dtPicker = function (dtControl)
		{
			dtControl.datetimepicker(dateTimePickerConf);
		}
		
		dtPicker(demandStartDateTime);
		dtPicker(demandEndDateTime);
		
		
		
		var offSet = {};
		$('.classImages').bind
		(
			'mouseover mouseout',
			function ()
			{
				switch (event.type)
				{
					case 'mouseover':
						offSet = {left : -5};
						break;
					case 'mouseout':
						offSet = {left : 0};
						break;
				}
				$(this).animate(offSet);
			}
		);
		
		$('.timeArea').bind
		(
			'mouseover mouseout',
			function ()
			{
				switch (event.type)
				{
					case 'mouseover':
						$(this).animate({top : -24});
						$(this).next('span').animate({top: 0});
						break;
					case 'mouseout':
						$(this).animate({top : 0});
						$(this).next('span').animate({top: 24});
						break;
				}
			}
		);

	}
);


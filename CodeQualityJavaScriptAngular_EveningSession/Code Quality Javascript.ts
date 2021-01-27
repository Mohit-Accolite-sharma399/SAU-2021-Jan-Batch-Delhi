
// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.

/* I have given comments in this file and changes are being made in the next file */


import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

//Import statement should be written in single line if possible because it gives better readability
import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';

//all import statement should be at the top of the page
import { selectedNoteSelector } from '../../src/selectors/notesSelector';

//all import statement should be at the top of the page
import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';



// Naming Convention for Constants Should be all uppercase with words separated by underscores (“_”).
export const NoteListSize = 500;

//Constants Should be all uppercase with words separated by underscores (“_”).
const AnotherCOnst = 0.7;

//all import statement should be at the top of the page
import { useSelector } from 'react-redux';

//Naming Convention for Constants Should be all uppercase with words separated by underscores (“_”).
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;

//Naming Convention for Constants Should be all uppercase with words separated by underscores (“_”).
export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = (
  filters,sort,disablePagination,skip: boolean = false,
) => {
  //Constants Should be all uppercase with words separated by underscores (“_”)
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);
  const TOTALNOTES = useRef<number>(0);

  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );
  
  //Constants Should be all uppercase with words separated by underscores (“_”)
  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;
  
  //Constants Should be all uppercase with words separated by underscores (“_”)
  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;
  
  //Constants Should be all uppercase with words separated by underscores (“_”) and some indentation issue also
  const prevPageSize =
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
	
  //Constants Should be all uppercase with words separated by underscores (“_”) and each expression should be closed in brackets for better readability
  const shouldPrevPageLoad =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;

  //Constants Should be all uppercase with words separated by underscores (“_”)
  const randomFunction = useMemo(() => {
    let innerlist = CURRENT_PAGE.data
      .concat(
        addDebugInfo(CURRENT_PAGE?.data ?? [], {
          pageName: 'current',
          cached: CURRENT_PAGE === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,
    startIndex,
    CURRENT_PAGE,
    isCurrentPageEmpty,
  ]);
  
//Constants Should be all uppercase with words separated by underscores (“_”)
  const result = useMemo(
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [
      CURRENT_PAGE
    ]
  );
  return result;
};

function createPlaceholders(count: number, selectedID?: string | null): Result {
  const placeholders: Array<Record<string, unknown>> = new Array(count);
  placeholders
    .fill(
      {
        id: selectedID,
		//It should be given null values 
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {	// It should be given null values 
        id: undefined,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
	//Constants Should be all uppercase with words separated by underscores (“_”)
  return (placeholders as unknown) as Result;
}

function addDebugInfo(
  list: Result,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): Result {
//Constants Should be all uppercase with words separated by underscores (“_”)
  if (debugPagination) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}
